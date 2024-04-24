/*
 * @ (#) ChiTietDDPId.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package entity;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietDDPId implements Serializable {
    private String maDDP;
    private String maMH;
}
