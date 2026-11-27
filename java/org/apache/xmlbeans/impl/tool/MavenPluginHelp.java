package org.apache.xmlbeans.impl.tool;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.connect.common.Constants;
import com.tencent.cursor.BuildConfig;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Mojo(name = "help", requiresProject = BuildConfig.DEBUG, threadSafe = Constants.FLAG_DEBUG)
/* loaded from: classes.dex */
public class MavenPluginHelp extends AbstractMojo {
    private static final int DEFAULT_LINE_LENGTH = 80;
    private static final String PLUGIN_HELP_PATH = "/META-INF/maven/plugin.xml";

    @Parameter(defaultValue = "false", property = "detail")
    private boolean detail;

    @Parameter(property = "goal")
    private String goal;

    @Parameter(defaultValue = "2", property = "indentSize")
    private int indentSize;

    @Parameter(defaultValue = "80", property = "lineLength")
    private int lineLength;

    private void append(StringBuilder sb, String str, int i2) {
        Iterator<String> it = toLines(str, i2, this.indentSize, this.lineLength).iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append('\n');
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Document build() throws IOException, MojoExecutionException {
        getLog().debug("load plugin-help.xml: /META-INF/maven/plugin.xml");
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream(PLUGIN_HELP_PATH);
            try {
                Document document = DocumentHelper.readDocument(new XmlOptions(), resourceAsStream);
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return document;
            } finally {
            }
        } catch (IOException | SAXException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    private List<Node> findNamedChild(Node node, String str) {
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (str.equals(nodeItem.getNodeName())) {
                arrayList.add(nodeItem);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Node findSingleChild(Node node, String str) throws MojoExecutionException {
        List<Node> listFindNamedChild = findNamedChild(node, str);
        if (listFindNamedChild.isEmpty()) {
            return null;
        }
        if (listFindNamedChild.size() <= 1) {
            return listFindNamedChild.get(0);
        }
        throw new MojoExecutionException("Multiple " + str + "in plugin.xml");
    }

    private static int getIndentLevel(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length() && str.charAt(i3) == '\t'; i3++) {
            i2++;
        }
        int i4 = i2 + 1;
        for (int i5 = i4; i5 <= i2 + 4 && i5 < str.length(); i5++) {
            if (str.charAt(i5) == '\t') {
                return i4;
            }
        }
        return i2;
    }

    private String getPropertyFromExpression(String str) {
        if (str == null || !str.startsWith("${") || !str.endsWith("}") || str.substring(2).contains("${")) {
            return null;
        }
        return str.substring(2, str.length() - 1);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Node getSingleChild(Node node, String str) throws MojoExecutionException {
        List<Node> listFindNamedChild = findNamedChild(node, str);
        if (listFindNamedChild.isEmpty()) {
            throw new MojoExecutionException("Could not find " + str + " in plugin.xml");
        }
        if (listFindNamedChild.size() <= 1) {
            return listFindNamedChild.get(0);
        }
        throw new MojoExecutionException("Multiple " + str + " in plugin.xml");
    }

    private String getValue(Node node, String str) throws MojoExecutionException {
        return getSingleChild(node, str).getTextContent();
    }

    private static boolean isNotEmpty(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private static String repeat(String str, int i2) {
        StringBuilder sb = new StringBuilder(str.length() * i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static List<String> toLines(String str, int i2, int i3, int i4) {
        ArrayList arrayList = new ArrayList();
        String strRepeat = repeat("\t", i2);
        for (String str2 : str.split("(\r\n)|(\r)|(\n)")) {
            toLines(arrayList, strRepeat + str2, i3, i4);
        }
        return arrayList;
    }

    private void writeGoal(StringBuilder sb, String str, Element element) throws MojoExecutionException {
        String value = getValue(element, "goal");
        Node nodeFindSingleChild = findSingleChild(element, "configuration");
        Node nodeFindSingleChild2 = findSingleChild(element, SocialConstants.PARAM_COMMENT);
        String str2 = this.goal;
        if (str2 == null || str2.length() <= 0 || value.equals(this.goal)) {
            append(sb, str + ParameterizedMessage.ERROR_MSG_SEPARATOR + value, 0);
            Node nodeFindSingleChild3 = findSingleChild(element, "deprecated");
            if (nodeFindSingleChild3 != null && isNotEmpty(nodeFindSingleChild3.getTextContent())) {
                append(sb, "Deprecated. " + nodeFindSingleChild3.getTextContent(), 1);
                if (this.detail && nodeFindSingleChild2 != null) {
                    append(sb, "", 0);
                    append(sb, nodeFindSingleChild2.getTextContent(), 1);
                }
            } else if (nodeFindSingleChild2 != null) {
                append(sb, nodeFindSingleChild2.getTextContent(), 1);
            }
            append(sb, "", 0);
            if (this.detail) {
                List<Node> listFindNamedChild = findNamedChild(getSingleChild(element, "parameters"), "parameter");
                append(sb, "Available parameters:", 1);
                append(sb, "", 0);
                Iterator<Node> it = listFindNamedChild.iterator();
                while (it.hasNext()) {
                    writeParameter(sb, it.next(), nodeFindSingleChild);
                }
            }
        }
    }

    private void writeParameter(StringBuilder sb, Node node, Node node2) throws MojoExecutionException {
        String str;
        String value = getValue(node, "name");
        String value2 = getValue(node, SocialConstants.PARAM_COMMENT);
        Element element = node2 != null ? (Element) findSingleChild(node2, value) : null;
        if (element == null || !element.hasAttribute("default-value")) {
            str = "";
        } else {
            str = " (Default: " + element.getAttribute("default-value") + ")";
        }
        append(sb, value + str, 2);
        Node nodeFindSingleChild = findSingleChild(node, "deprecated");
        if (nodeFindSingleChild != null && isNotEmpty(nodeFindSingleChild.getTextContent())) {
            append(sb, "Deprecated. " + nodeFindSingleChild.getTextContent(), 3);
            append(sb, "", 0);
        }
        append(sb, value2, 3);
        if ("true".equals(getValue(node, "required"))) {
            append(sb, "Required: Yes", 3);
        }
        if (element != null && isNotEmpty(element.getTextContent())) {
            append(sb, "User property: " + getPropertyFromExpression(element.getTextContent()), 3);
        }
        append(sb, "", 0);
    }

    public void execute() throws IOException, MojoExecutionException {
        if (this.lineLength <= 0) {
            getLog().warn("The parameter 'lineLength' should be positive, using '80' as default.");
            this.lineLength = 80;
        }
        if (this.indentSize <= 0) {
            getLog().warn("The parameter 'indentSize' should be positive, using '2' as default.");
            this.indentSize = 2;
        }
        Document documentBuild = build();
        StringBuilder sb = new StringBuilder();
        Node singleChild = getSingleChild(documentBuild, "plugin");
        String value = getValue(singleChild, "name");
        String value2 = getValue(singleChild, "version");
        String str = getValue(singleChild, "groupId") + ParameterizedMessage.ERROR_MSG_SEPARATOR + getValue(singleChild, "artifactId") + ParameterizedMessage.ERROR_MSG_SEPARATOR + value2;
        if (isNotEmpty(value) && !value.contains(str)) {
            append(sb, value + " " + value2, 0);
        } else if (isNotEmpty(value)) {
            append(sb, value, 0);
        } else {
            append(sb, str, 0);
        }
        append(sb, getValue(singleChild, SocialConstants.PARAM_COMMENT), 1);
        append(sb, "", 0);
        String value3 = getValue(singleChild, "goalPrefix");
        List<Node> listFindNamedChild = findNamedChild(getSingleChild(singleChild, "mojos"), "mojo");
        String str2 = this.goal;
        if (str2 == null || str2.length() <= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("This plugin has ");
            sb2.append(listFindNamedChild.size());
            sb2.append(listFindNamedChild.size() > 1 ? " goals:" : " goal:");
            append(sb, sb2.toString(), 0);
            append(sb, "", 0);
        }
        Iterator<Node> it = listFindNamedChild.iterator();
        while (it.hasNext()) {
            writeGoal(sb, value3, (Element) it.next());
        }
        if (getLog().isInfoEnabled()) {
            getLog().info(sb.toString());
        }
    }

    private static void toLines(List<String> list, String str, int i2, int i3) {
        int indentLevel = getIndentLevel(str);
        StringBuilder sb = new StringBuilder(256);
        for (String str2 : str.split(" +")) {
            if (sb.length() > 0) {
                if (sb.length() + str2.length() >= i3) {
                    list.add(sb.toString());
                    sb.setLength(0);
                    sb.append(repeat(" ", indentLevel * i2));
                } else {
                    sb.append(Chars.SPACE);
                }
            }
            for (int i4 = 0; i4 < str2.length(); i4++) {
                char cCharAt = str2.charAt(i4);
                if (cCharAt == '\t') {
                    sb.append(repeat(" ", i2 - (sb.length() % i2)));
                } else if (cCharAt == 160) {
                    sb.append(Chars.SPACE);
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        list.add(sb.toString());
    }
}
