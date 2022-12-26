package ru.otus.tests;

import ru.otus.ammount_worder.common.IOService;

import java.util.List;

public class IOServiceSpy implements IOService {

    private final List<String> actualFlow;
    private final String[] valuesForRead;
    private int counter = 0;

    public IOServiceSpy(List<String> actualFlow, String[] valuesForRead) {
        this.actualFlow = actualFlow;
        this.valuesForRead = valuesForRead;
    }

    @Override
    public void outputStr(String s) {
        actualFlow.add(String.format("outputStr: %s", s));
    }

    @Override
    public void outputStr(String template, Object... args) {
        String outStr = String.format(template,args);
        actualFlow.add(String.format("outputStr: %s", outStr));
    }

    @Override
    public String readString() {
        actualFlow.add(String.format("readString: %s", valuesForRead[counter]));
        return valuesForRead[counter++];
    }


}
