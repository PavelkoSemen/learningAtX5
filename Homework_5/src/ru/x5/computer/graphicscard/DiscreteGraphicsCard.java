package ru.x5.computer.graphicscard;

public class DiscreteGraphicsCard extends GraphicsCard {
    private String typeSlot;

    public DiscreteGraphicsCard() {
        super(2048, "DDR5", "AMD");
        this.typeSlot = "PCI-Express";
    }

    public DiscreteGraphicsCard(int memoryCount, String typeMemory, String manufacturer, String typeSlot) {
        super(memoryCount, typeMemory, manufacturer);
        this.typeSlot = typeSlot;
    }

    @Override
    public String cardInfo() {
        return "Внешняя видеокарта " + super.baseCardInfo() +
                ", тип слота " + this.typeSlot;
    }
}
