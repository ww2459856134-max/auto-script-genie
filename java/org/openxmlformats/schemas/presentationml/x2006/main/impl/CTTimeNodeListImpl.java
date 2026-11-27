package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateColorBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateEffectBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateMotionBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateRotationBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateScaleBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommandBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeVideo;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSetBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeExclusive;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeSequence;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;

/* loaded from: classes2.dex */
public class CTTimeNodeListImpl extends XmlComplexContentImpl implements CTTimeNodeList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "par"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "seq"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "excl"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "anim"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animClr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animEffect"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animMotion"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animRot"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animScale"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cmd"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "set"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "audio"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "video")};
    private static final long serialVersionUID = 1;

    public CTTimeNodeListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior addNewAnim() {
        CTTLAnimateBehavior cTTLAnimateBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLAnimateBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior addNewAnimClr() {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTLAnimateColorBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior addNewAnimEffect() {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTLAnimateEffectBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior addNewAnimMotion() {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTLAnimateMotionBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior addNewAnimRot() {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTLAnimateRotationBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior addNewAnimScale() {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTLAnimateScaleBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio addNewAudio() {
        CTTLMediaNodeAudio cTTLMediaNodeAudioAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudioAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTTLMediaNodeAudioAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior addNewCmd() {
        CTTLCommandBehavior cTTLCommandBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTLCommandBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive addNewExcl() {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLTimeNodeExclusiveAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel addNewPar() {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence addNewSeq() {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTLTimeNodeSequenceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior addNewSet() {
        CTTLSetBehavior cTTLSetBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTTLSetBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo addNewVideo() {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior[] getAnimArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTTLAnimateBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior[] getAnimClrArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTTLAnimateColorBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateColorBehavior> getAnimClrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.u3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnimClrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.k2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnimClrArray(((Integer) obj).intValue(), (CTTLAnimateColorBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.f1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnimClr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.e0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnimClr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.m
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnimClrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior[] getAnimEffectArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTTLAnimateEffectBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateEffectBehavior> getAnimEffectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.m3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnimEffectArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.o0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnimEffectArray(((Integer) obj).intValue(), (CTTLAnimateEffectBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.c2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnimEffect(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.g3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnimEffect(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.f2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnimEffectArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateBehavior> getAnimList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.r3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnimArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.c1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnimArray(((Integer) obj).intValue(), (CTTLAnimateBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.n0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnim(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.q
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnim(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.h1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnimArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior[] getAnimMotionArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTTLAnimateMotionBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateMotionBehavior> getAnimMotionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.b3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnimMotionArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.n3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnimMotionArray(((Integer) obj).intValue(), (CTTLAnimateMotionBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.k0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnimMotion(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.b1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnimMotion(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.d1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnimMotionArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior[] getAnimRotArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTTLAnimateRotationBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateRotationBehavior> getAnimRotList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.r1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnimRotArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.y2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnimRotArray(((Integer) obj).intValue(), (CTTLAnimateRotationBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.z1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnimRot(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnimRot(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.a1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnimRotArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior[] getAnimScaleArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTTLAnimateScaleBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateScaleBehavior> getAnimScaleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.x3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnimScaleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.a3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnimScaleArray(((Integer) obj).intValue(), (CTTLAnimateScaleBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.p1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnimScale(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.q0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnimScale(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.t
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnimScaleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio[] getAudioArray() {
        return getXmlObjectArray(PROPERTY_QNAME[11], (XmlObject[]) new CTTLMediaNodeAudio[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLMediaNodeAudio> getAudioList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.x2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAudioArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.t2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAudioArray(((Integer) obj).intValue(), (CTTLMediaNodeAudio) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.j3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAudio(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.u1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAudio(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.f
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAudioArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior[] getCmdArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTTLCommandBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLCommandBehavior> getCmdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.z2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCmdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.h
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCmdArray(((Integer) obj).intValue(), (CTTLCommandBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.z
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCmd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.m2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCmd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.l2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCmdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive[] getExclArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTTLTimeNodeExclusive[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeExclusive> getExclList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.y3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getExclArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.o2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setExclArray(((Integer) obj).intValue(), (CTTLTimeNodeExclusive) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.d3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewExcl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.n2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeExcl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.a0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfExclArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel[] getParArray() {
        return (CTTLTimeNodeParallel[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTLTimeNodeParallel[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeParallel> getParList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.r0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getParArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.o3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setParArray(((Integer) obj).intValue(), (CTTLTimeNodeParallel) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.v3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPar(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.x1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePar(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.k1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfParArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence[] getSeqArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTTLTimeNodeSequence[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeSequence> getSeqList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.r2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSeqArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.t1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSeqArray(((Integer) obj).intValue(), (CTTLTimeNodeSequence) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.b2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSeq(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.y1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSeq(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.q2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSeqArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior[] getSetArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTTLSetBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLSetBehavior> getSetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.m1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSetArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.w0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSetArray(((Integer) obj).intValue(), (CTTLSetBehavior) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.x
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSet(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSet(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.e2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSetArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo[] getVideoArray() {
        return (CTTLMediaNodeVideo[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTTLMediaNodeVideo[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLMediaNodeVideo> getVideoList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.y
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getVideoArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.l
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setVideoArray(((Integer) obj).intValue(), (CTTLMediaNodeVideo) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.d2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewVideo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.c0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeVideo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.i3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfVideoArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior insertNewAnim(int i2) {
        CTTLAnimateBehavior cTTLAnimateBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTTLAnimateBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior insertNewAnimClr(int i2) {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTTLAnimateColorBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior insertNewAnimEffect(int i2) {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTTLAnimateEffectBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior insertNewAnimMotion(int i2) {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTTLAnimateMotionBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior insertNewAnimRot(int i2) {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTTLAnimateRotationBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior insertNewAnimScale(int i2) {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTTLAnimateScaleBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio insertNewAudio(int i2) {
        CTTLMediaNodeAudio cTTLMediaNodeAudioInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudioInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTTLMediaNodeAudioInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior insertNewCmd(int i2) {
        CTTLCommandBehavior cTTLCommandBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTTLCommandBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive insertNewExcl(int i2) {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTTLTimeNodeExclusiveInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel insertNewPar(int i2) {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence insertNewSeq(int i2) {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTTLTimeNodeSequenceInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior insertNewSet(int i2) {
        CTTLSetBehavior cTTLSetBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTTLSetBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo insertNewVideo(int i2) {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnim(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimClr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimEffect(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimMotion(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimRot(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimScale(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAudio(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeCmd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeExcl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removePar(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeSeq(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeSet(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeVideo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimArray(CTTLAnimateBehavior[] cTTLAnimateBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateBehaviorArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimClrArray(CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateColorBehaviorArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimEffectArray(CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateEffectBehaviorArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimMotionArray(CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateMotionBehaviorArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimRotArray(CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateRotationBehaviorArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimScaleArray(CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateScaleBehaviorArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAudioArray(CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLMediaNodeAudioArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setCmdArray(CTTLCommandBehavior[] cTTLCommandBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLCommandBehaviorArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setExclArray(CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLTimeNodeExclusiveArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setParArray(CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr) {
        check_orphaned();
        arraySetterHelper(cTTLTimeNodeParallelArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSeqArray(CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLTimeNodeSequenceArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSetArray(CTTLSetBehavior[] cTTLSetBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLSetBehaviorArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setVideoArray(CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr) {
        check_orphaned();
        arraySetterHelper(cTTLMediaNodeVideoArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimClrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimEffectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimMotionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimRotArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimScaleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAudioArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfCmdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfExclArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfParArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfSeqArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfSetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfVideoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior getAnimArray(int i2) {
        CTTLAnimateBehavior cTTLAnimateBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTTLAnimateBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLAnimateBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior getAnimClrArray(int i2) {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTTLAnimateColorBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLAnimateColorBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior getAnimEffectArray(int i2) {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTTLAnimateEffectBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLAnimateEffectBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior getAnimMotionArray(int i2) {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTTLAnimateMotionBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLAnimateMotionBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior getAnimRotArray(int i2) {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTTLAnimateRotationBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLAnimateRotationBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior getAnimScaleArray(int i2) {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTTLAnimateScaleBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLAnimateScaleBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio getAudioArray(int i2) {
        CTTLMediaNodeAudio cTTLMediaNodeAudioFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudioFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTTLMediaNodeAudioFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLMediaNodeAudioFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior getCmdArray(int i2) {
        CTTLCommandBehavior cTTLCommandBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTTLCommandBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLCommandBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive getExclArray(int i2) {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTTLTimeNodeExclusiveFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLTimeNodeExclusiveFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel getParArray(int i2) {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTLTimeNodeParallel == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence getSeqArray(int i2) {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTTLTimeNodeSequenceFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLTimeNodeSequenceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior getSetArray(int i2) {
        CTTLSetBehavior cTTLSetBehaviorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTTLSetBehaviorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLSetBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo getVideoArray(int i2) {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTTLMediaNodeVideo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimArray(int i2, CTTLAnimateBehavior cTTLAnimateBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLAnimateBehavior, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimClrArray(int i2, CTTLAnimateColorBehavior cTTLAnimateColorBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLAnimateColorBehavior, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimEffectArray(int i2, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLAnimateEffectBehavior, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimMotionArray(int i2, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLAnimateMotionBehavior, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimRotArray(int i2, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLAnimateRotationBehavior, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimScaleArray(int i2, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLAnimateScaleBehavior, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAudioArray(int i2, CTTLMediaNodeAudio cTTLMediaNodeAudio) throws Throwable {
        generatedSetterHelperImpl(cTTLMediaNodeAudio, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setCmdArray(int i2, CTTLCommandBehavior cTTLCommandBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLCommandBehavior, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setExclArray(int i2, CTTLTimeNodeExclusive cTTLTimeNodeExclusive) throws Throwable {
        generatedSetterHelperImpl(cTTLTimeNodeExclusive, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setParArray(int i2, CTTLTimeNodeParallel cTTLTimeNodeParallel) throws Throwable {
        generatedSetterHelperImpl(cTTLTimeNodeParallel, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSeqArray(int i2, CTTLTimeNodeSequence cTTLTimeNodeSequence) throws Throwable {
        generatedSetterHelperImpl(cTTLTimeNodeSequence, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSetArray(int i2, CTTLSetBehavior cTTLSetBehavior) throws Throwable {
        generatedSetterHelperImpl(cTTLSetBehavior, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setVideoArray(int i2, CTTLMediaNodeVideo cTTLMediaNodeVideo) throws Throwable {
        generatedSetterHelperImpl(cTTLMediaNodeVideo, PROPERTY_QNAME[12], i2, (short) 2);
    }
}
