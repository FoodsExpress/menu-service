package com.foodexpress.menuservice.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("page")
public class PageProperties {

    private int defaultSize;

}
