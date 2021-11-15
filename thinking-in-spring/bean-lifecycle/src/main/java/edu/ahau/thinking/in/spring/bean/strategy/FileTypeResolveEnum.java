package edu.ahau.thinking.in.spring.bean.strategy;

/**
 * @author zhangxuna
 * @date 2021-10-28 9:10
 */
public enum FileTypeResolveEnum {
    File_A_RESOLVE(1),
    File_B_RESOLVE(2),
    File_Default_RESOLVE(3);

    private Integer valueNum;
    private FileTypeResolveEnum (Integer value) {
        this.valueNum = value;
    }

    public Integer getValue() {
        return valueNum;
    }

    public void setValue(Integer value) {
        this.valueNum = value;
    }

    public static FileTypeResolveEnum matchByValue(Integer value) {
        FileTypeResolveEnum[] values = FileTypeResolveEnum.values();
        for (FileTypeResolveEnum statusEnum : values) {
            if (value.equals(statusEnum.getValue())) {
                return statusEnum;
            }
        }
        return null;
    }
}
