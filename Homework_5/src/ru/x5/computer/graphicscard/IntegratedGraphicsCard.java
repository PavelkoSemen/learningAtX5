package ru.x5.computer.graphicscard;

public class IntegratedGraphicsCard extends GraphicsCard {
    //Встроенные видеокарты, в качестве буфера используют оперативную память
    private int usedRAM;

    public IntegratedGraphicsCard() {
        super(2048, "DDR5", "Intel");
        this.usedRAM = 1024;
    }

    public IntegratedGraphicsCard(int memoryCount, String typeMemory, String manufacturer, int usedRAM) {
        super(memoryCount, typeMemory, manufacturer);
        this.usedRAM = usedRAM;
    }

    @Override
    public String cardInfo() {
        return "Встроенная видеокарта " + super.baseCardInfo() +
                ", используемая RAM " + this.usedRAM;
    }

}
