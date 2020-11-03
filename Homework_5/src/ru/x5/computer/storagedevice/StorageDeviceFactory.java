package ru.x5.computer.storagedevice;

import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;

public class StorageDeviceFactory implements ComponentFactory<TypeStorageDevice> {
    @Override
    public Component createComponent(TypeStorageDevice typeStorageDevice) {
        Component StorageDevice = null;
        switch (typeStorageDevice) {
            case SSD:
                StorageDevice = new SSD();
                break;
            case HDD:
                StorageDevice = new HDD();
                break;
            default:
                throw new IllegalArgumentException("Несуществующий тип накопителя");
        }
        return StorageDevice;
    }
}
