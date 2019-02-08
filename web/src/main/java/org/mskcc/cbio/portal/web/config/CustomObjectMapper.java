package org.mskcc.cbio.portal.web.config;

import java.util.HashMap;
import java.util.Map;

import org.cbioportal.weblegacy.mixin.VirtualStudyDataMixin;
import org.cbioportal.weblegacy.mixin.VirtualStudyMixin;
import org.mskcc.cbio.portal.model.virtualstudy.VirtualStudy;
import org.mskcc.cbio.portal.model.virtualstudy.VirtualStudyData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {

        super.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        super.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        Map<Class<?>, Class<?>> mixinMap = new HashMap<>();
        mixinMap.put(VirtualStudy.class, VirtualStudyMixin.class);
        mixinMap.put(VirtualStudyData.class, VirtualStudyDataMixin.class);
        super.setMixIns(mixinMap);
    }
}