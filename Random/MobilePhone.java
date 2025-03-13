public class MobilePhone {
    
    //instance variable
    int storage;
    int ram;
    double camera;
    double price;

    //Static/class Variable
    static String shopName = "Gada ELectronics";

    //default constructor
    public MobilePhone() {}
    
    //parametrized constructor
    public MobilePhone(int storage, int ram, double camera, double price) {
        this.storage = storage;
        this.ram = ram;
        this.camera= camera;
        this.price = price;
    }
    //setters getters
    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStorage() {
        return storage;
    }

    public int getRam() {
        return ram;
    }

    public double getCamera() {
        return camera;
    }

    public double getPrice() {
        return price;
    }

    public static String getShopName(){
        return shopName;
    }

    public static void setShopName(String shopName){
        MobilePhone.shopName = shopName;

    }
    
    //object creation
    public static void main(String[] args) {

        MobilePhone obj1 = new MobilePhone();

        obj1.storage = 256;
        obj1.ram = 12;
        obj1.setCamera(100.2);
        obj1.setPrice(150000.5);

        MobilePhone obj2 = new MobilePhone(512,16,50.2,100000.5);

        System.out.println("Welcome to"+shopName+'!');
        System.out.println("Storage: "+obj1.getStorage()+"GB, Ram: "+obj1.getRam()+"GB");
        System.out.println("Storage: "+obj2.storage+"GB, Ram: "+obj2.ram+"GB");

    }

}

