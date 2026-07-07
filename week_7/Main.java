public class Main {
    public static void main(String[] args) {
        Appliance wm = new WashingMachine("LG");
        wm.displayBrand();
        wm.turnOn();
        wm.operate();
        wm.turnOff();

        System.out.println();

        Appliance ref = new Refrigerator("Panasonic");
        ref.displayBrand();
        ref.turnOn();
        ref.operate();
        ref.turnOff();
    }
}