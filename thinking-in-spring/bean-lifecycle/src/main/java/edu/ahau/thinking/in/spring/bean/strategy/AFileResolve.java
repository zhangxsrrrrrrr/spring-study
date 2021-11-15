package edu.ahau.thinking.in.spring.bean.strategy;

import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-10-28 9:10
 */
@Component
public class AFileResolve implements IFileStrategy {
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_A_RESOLVE;
    }

    @Override
    public void resolve(Object objectparam) {
        System.out.printf("A 类型解析文件，参数：%s",objectparam);
        //A类型解析具体逻辑
        objectparam = "144423";
    }
}

