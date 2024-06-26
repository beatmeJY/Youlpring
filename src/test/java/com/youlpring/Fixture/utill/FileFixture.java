package com.youlpring.Fixture.utill;

import com.youlpring.tomcat.apache.util.FileUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileFixture {

    private FileFixture() {
        throw new AssertionError("올바른 방식의 객체를 생성해주세요");
    }

    public static final String STATIC_FILE = "/youlpring.txt";
    public static final String DYNAMIC_URL = "/index";

    public static final String STATIC_FILE_PATH = "static/youlpring.txt";
    public static final String DYNAMIC_FILE_PATH_BY_LOGIN = "templates/index-login.html";
    public static final String DYNAMIC_FILE_PATH_BY_LOGOUT = "templates/index-logout.html";


    public static String readStaticTextFile() {
        try {
            URI uri = FileUtil.class.getClassLoader().getResource(FileFixture.STATIC_FILE_PATH).toURI();
            return Files.readString(Path.of(uri));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("정적 파일 읽기에 실패하였습니다.");
        }
    }

    public static String readDynamicFileNotLoggedIn() {
        try {
            URI uri = FileUtil.class.getClassLoader().getResource(FileFixture.DYNAMIC_FILE_PATH_BY_LOGIN).toURI();
            return Files.readString(Path.of(uri));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("동적 파일 읽기에 실패하였습니다.");
        }
    }

    public static String readDynamicFileLoggedIn() {
        try {
            URI uri = FileUtil.class.getClassLoader().getResource(FileFixture.DYNAMIC_FILE_PATH_BY_LOGOUT).toURI();
            return Files.readString(Path.of(uri));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("동적 파일 읽기에 실패하였습니다.");
        }
    }
}
