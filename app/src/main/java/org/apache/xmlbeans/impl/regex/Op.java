package org.apache.xmlbeans.impl.regex;

import java.util.Vector;

/* loaded from: classes.dex */
class Op {
    static final int ANCHOR = 5;
    static final int BACKREFERENCE = 16;
    static final int CAPTURE = 15;
    static final int CHAR = 1;
    static final int CLOSURE = 7;
    static final int CONDITION = 26;
    static final boolean COUNT = false;
    static final int DOT = 0;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIER = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    static final int NONGREEDYCLOSURE = 8;
    static final int NONGREEDYQUESTION = 10;
    static final int NRANGE = 4;
    static final int QUESTION = 9;
    static final int RANGE = 3;
    static final int STRING = 6;
    static final int UNION = 11;
    static int nofinstances;
    Op next = null;
    int type;

    static class CharOp extends Op {
        int charData;

        CharOp(int i2, int i3) {
            super(i2);
            this.charData = i3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int getData() {
            return this.charData;
        }
    }

    static class ChildOp extends Op {
        Op child;

        ChildOp(int i2) {
            super(i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        Op getChild() {
            return this.child;
        }

        void setChild(Op op) {
            this.child = op;
        }
    }

    static class ConditionOp extends Op {
        Op condition;
        Op no;
        int refNumber;
        Op yes;

        ConditionOp(int i2, int i3, Op op, Op op2, Op op3) {
            super(i2);
            this.refNumber = i3;
            this.condition = op;
            this.yes = op2;
            this.no = op3;
        }
    }

    static class ModifierOp extends ChildOp {
        int v1;
        int v2;

        ModifierOp(int i2, int i3, int i4) {
            super(i2);
            this.v1 = i3;
            this.v2 = i4;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int getData() {
            return this.v1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int getData2() {
            return this.v2;
        }
    }

    static class RangeOp extends Op {
        Token tok;

        RangeOp(int i2, Token token) {
            super(i2);
            this.tok = token;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        RangeToken getToken() {
            return (RangeToken) this.tok;
        }
    }

    static class StringOp extends Op {
        String string;

        StringOp(int i2, String str) {
            super(i2);
            this.string = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        String getString() {
            return this.string;
        }
    }

    static class UnionOp extends Op {
        Vector branches;

        UnionOp(int i2, int i3) {
            super(i2);
            this.branches = new Vector(i3);
        }

        void addElement(Op op) {
            this.branches.addElement(op);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        Op elementAt(int i2) {
            return (Op) this.branches.elementAt(i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int size() {
            return this.branches.size();
        }
    }

    protected Op(int i2) {
        this.type = i2;
    }

    static CharOp createAnchor(int i2) {
        return new CharOp(5, i2);
    }

    static CharOp createBackReference(int i2) {
        return new CharOp(16, i2);
    }

    static CharOp createCapture(int i2, Op op) {
        CharOp charOp = new CharOp(15, i2);
        charOp.next = op;
        return charOp;
    }

    static CharOp createChar(int i2) {
        return new CharOp(1, i2);
    }

    static ChildOp createClosure(int i2) {
        return new ModifierOp(7, i2, -1);
    }

    static ConditionOp createCondition(Op op, int i2, Op op2, Op op3, Op op4) {
        ConditionOp conditionOp = new ConditionOp(26, i2, op2, op3, op4);
        conditionOp.next = op;
        return conditionOp;
    }

    static Op createDot() {
        return new Op(0);
    }

    static ChildOp createIndependent(Op op, Op op2) {
        ChildOp childOp = new ChildOp(24);
        childOp.setChild(op2);
        childOp.next = op;
        return childOp;
    }

    static ChildOp createLook(int i2, Op op, Op op2) {
        ChildOp childOp = new ChildOp(i2);
        childOp.setChild(op2);
        childOp.next = op;
        return childOp;
    }

    static ModifierOp createModifier(Op op, Op op2, int i2, int i3) {
        ModifierOp modifierOp = new ModifierOp(25, i2, i3);
        modifierOp.setChild(op2);
        modifierOp.next = op;
        return modifierOp;
    }

    static ChildOp createNonGreedyClosure() {
        return new ChildOp(8);
    }

    static ChildOp createQuestion(boolean z) {
        return new ChildOp(z ? 10 : 9);
    }

    static RangeOp createRange(Token token) {
        return new RangeOp(3, token);
    }

    static StringOp createString(String str) {
        return new StringOp(6, str);
    }

    static UnionOp createUnion(int i2) {
        return new UnionOp(11, i2);
    }

    Op elementAt(int i2) {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    Op getChild() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    int getData() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    int getData2() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    String getString() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    RangeToken getToken() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    int size() {
        return 0;
    }
}
