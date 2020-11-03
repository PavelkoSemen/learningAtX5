package ru.x5.computer.storagedevice;

import ru.x5.computer.component.Component;

public abstract class StorageDevice implements Component {
    private int memoryCount;
    private String manufacturer;
    private String forms;
    private String storageType;

    public StorageDevice(int memoryCount, String manufacturer, String forms, String storageType) {
        this.memoryCount = memoryCount;
        this.manufacturer = manufacturer;
        this.forms = forms;
        this.storageType = storageType;
    }

    public String baseStorageDeviceInfo() {
        return this.manufacturer + ", количество памяти " +
                this.memoryCount + ", форм-фактор " +
                this.forms + ", тип накопителя" +
                this.storageType;
    }
}
