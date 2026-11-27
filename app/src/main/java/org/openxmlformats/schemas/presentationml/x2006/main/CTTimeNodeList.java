package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTTimeNodeList extends XmlObject {
    public static final DocumentFactory<CTTimeNodeList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTimeNodeList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttimenodelist0258type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTLAnimateBehavior addNewAnim();

    CTTLAnimateColorBehavior addNewAnimClr();

    CTTLAnimateEffectBehavior addNewAnimEffect();

    CTTLAnimateMotionBehavior addNewAnimMotion();

    CTTLAnimateRotationBehavior addNewAnimRot();

    CTTLAnimateScaleBehavior addNewAnimScale();

    CTTLMediaNodeAudio addNewAudio();

    CTTLCommandBehavior addNewCmd();

    CTTLTimeNodeExclusive addNewExcl();

    CTTLTimeNodeParallel addNewPar();

    CTTLTimeNodeSequence addNewSeq();

    CTTLSetBehavior addNewSet();

    CTTLMediaNodeVideo addNewVideo();

    CTTLAnimateBehavior getAnimArray(int i2);

    CTTLAnimateBehavior[] getAnimArray();

    CTTLAnimateColorBehavior getAnimClrArray(int i2);

    CTTLAnimateColorBehavior[] getAnimClrArray();

    List<CTTLAnimateColorBehavior> getAnimClrList();

    CTTLAnimateEffectBehavior getAnimEffectArray(int i2);

    CTTLAnimateEffectBehavior[] getAnimEffectArray();

    List<CTTLAnimateEffectBehavior> getAnimEffectList();

    List<CTTLAnimateBehavior> getAnimList();

    CTTLAnimateMotionBehavior getAnimMotionArray(int i2);

    CTTLAnimateMotionBehavior[] getAnimMotionArray();

    List<CTTLAnimateMotionBehavior> getAnimMotionList();

    CTTLAnimateRotationBehavior getAnimRotArray(int i2);

    CTTLAnimateRotationBehavior[] getAnimRotArray();

    List<CTTLAnimateRotationBehavior> getAnimRotList();

    CTTLAnimateScaleBehavior getAnimScaleArray(int i2);

    CTTLAnimateScaleBehavior[] getAnimScaleArray();

    List<CTTLAnimateScaleBehavior> getAnimScaleList();

    CTTLMediaNodeAudio getAudioArray(int i2);

    CTTLMediaNodeAudio[] getAudioArray();

    List<CTTLMediaNodeAudio> getAudioList();

    CTTLCommandBehavior getCmdArray(int i2);

    CTTLCommandBehavior[] getCmdArray();

    List<CTTLCommandBehavior> getCmdList();

    CTTLTimeNodeExclusive getExclArray(int i2);

    CTTLTimeNodeExclusive[] getExclArray();

    List<CTTLTimeNodeExclusive> getExclList();

    CTTLTimeNodeParallel getParArray(int i2);

    CTTLTimeNodeParallel[] getParArray();

    List<CTTLTimeNodeParallel> getParList();

    CTTLTimeNodeSequence getSeqArray(int i2);

    CTTLTimeNodeSequence[] getSeqArray();

    List<CTTLTimeNodeSequence> getSeqList();

    CTTLSetBehavior getSetArray(int i2);

    CTTLSetBehavior[] getSetArray();

    List<CTTLSetBehavior> getSetList();

    CTTLMediaNodeVideo getVideoArray(int i2);

    CTTLMediaNodeVideo[] getVideoArray();

    List<CTTLMediaNodeVideo> getVideoList();

    CTTLAnimateBehavior insertNewAnim(int i2);

    CTTLAnimateColorBehavior insertNewAnimClr(int i2);

    CTTLAnimateEffectBehavior insertNewAnimEffect(int i2);

    CTTLAnimateMotionBehavior insertNewAnimMotion(int i2);

    CTTLAnimateRotationBehavior insertNewAnimRot(int i2);

    CTTLAnimateScaleBehavior insertNewAnimScale(int i2);

    CTTLMediaNodeAudio insertNewAudio(int i2);

    CTTLCommandBehavior insertNewCmd(int i2);

    CTTLTimeNodeExclusive insertNewExcl(int i2);

    CTTLTimeNodeParallel insertNewPar(int i2);

    CTTLTimeNodeSequence insertNewSeq(int i2);

    CTTLSetBehavior insertNewSet(int i2);

    CTTLMediaNodeVideo insertNewVideo(int i2);

    void removeAnim(int i2);

    void removeAnimClr(int i2);

    void removeAnimEffect(int i2);

    void removeAnimMotion(int i2);

    void removeAnimRot(int i2);

    void removeAnimScale(int i2);

    void removeAudio(int i2);

    void removeCmd(int i2);

    void removeExcl(int i2);

    void removePar(int i2);

    void removeSeq(int i2);

    void removeSet(int i2);

    void removeVideo(int i2);

    void setAnimArray(int i2, CTTLAnimateBehavior cTTLAnimateBehavior);

    void setAnimArray(CTTLAnimateBehavior[] cTTLAnimateBehaviorArr);

    void setAnimClrArray(int i2, CTTLAnimateColorBehavior cTTLAnimateColorBehavior);

    void setAnimClrArray(CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr);

    void setAnimEffectArray(int i2, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior);

    void setAnimEffectArray(CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr);

    void setAnimMotionArray(int i2, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior);

    void setAnimMotionArray(CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr);

    void setAnimRotArray(int i2, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior);

    void setAnimRotArray(CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr);

    void setAnimScaleArray(int i2, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior);

    void setAnimScaleArray(CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr);

    void setAudioArray(int i2, CTTLMediaNodeAudio cTTLMediaNodeAudio);

    void setAudioArray(CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr);

    void setCmdArray(int i2, CTTLCommandBehavior cTTLCommandBehavior);

    void setCmdArray(CTTLCommandBehavior[] cTTLCommandBehaviorArr);

    void setExclArray(int i2, CTTLTimeNodeExclusive cTTLTimeNodeExclusive);

    void setExclArray(CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr);

    void setParArray(int i2, CTTLTimeNodeParallel cTTLTimeNodeParallel);

    void setParArray(CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr);

    void setSeqArray(int i2, CTTLTimeNodeSequence cTTLTimeNodeSequence);

    void setSeqArray(CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr);

    void setSetArray(int i2, CTTLSetBehavior cTTLSetBehavior);

    void setSetArray(CTTLSetBehavior[] cTTLSetBehaviorArr);

    void setVideoArray(int i2, CTTLMediaNodeVideo cTTLMediaNodeVideo);

    void setVideoArray(CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr);

    int sizeOfAnimArray();

    int sizeOfAnimClrArray();

    int sizeOfAnimEffectArray();

    int sizeOfAnimMotionArray();

    int sizeOfAnimRotArray();

    int sizeOfAnimScaleArray();

    int sizeOfAudioArray();

    int sizeOfCmdArray();

    int sizeOfExclArray();

    int sizeOfParArray();

    int sizeOfSeqArray();

    int sizeOfSetArray();

    int sizeOfVideoArray();
}
