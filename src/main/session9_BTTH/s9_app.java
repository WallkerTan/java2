package src.main.session9_BTTH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s9_app {

    public static void menu() {
        System.out.println("My MENU");
        System.out.println("0: them san pham DigitalProduct");
        System.out.println("1: them san pham PhysicalProduct");
        System.out.println("2: cap nhat san pham");
        System.out.println("3: xoa san pham");
        System.out.println("4: lay danh sach sp PhysicalProduct");
        System.out.println("5: lay danh sach sp DigitalProduct");
        System.out.println("6: thoat");
        System.out.printf("chose action -> ");
    }

    public static void outphy(List<Entity> Elist){
        List<Entity> newl = Elist.stream().filter(e->e instanceof PhysicalProduct).toList();
        newl.stream().forEach(e->{
            System.out.println(e.disPlayInfo());
        });
    }
    public static void outdig(List<Entity> Elist){
        List<Entity> newl = Elist.stream().filter(e->e instanceof DigitalProduct).toList();
        newl.stream().forEach(e->{
            System.out.println(e.disPlayInfo());
        });
    }

    public static void delete(Scanner sc,List<Entity> Elist){
        String id;
        System.out.println("nhap id can xoa");
        id = sc.nextLine();
        Entity e = Elist.stream().filter(t -> t.id.equals(id)).findFirst().orElse(null);
        
        if(e!=null){
            Elist.remove(e);
        }else{
            System.out.println("ko tim thay san pham");
        }
    }

    public static Entity createP(Scanner sc, int typeP) {
        String name;
        String price;
        int value;
        System.out.println("nhap ten sp");
        name = sc.nextLine();
        System.out.println("nhap gia san pham");
        price = sc.nextLine();
        System.out.println("nhap thong so san pham");
        value = sc.nextInt();
        sc.nextLine();
        return typeP == 1 ? new ProductFactory().createProduct("physical", name, price, value)
                : new ProductFactory().createProduct("digital", name, price, value);

    }

    public static void update(Scanner sc,List<Entity> Elist){
        String name;
        String price;
        int value;
        String id;
        System.out.println(" id can sua");
        id = sc.nextLine();

        Entity e = Elist.stream().filter((t) -> t.id.equals(id)).findFirst().orElse(null);
        if(e==null){
            System.out.println("khong tim thay");
        }
        System.out.println("nhap ten sp");
        name = sc.nextLine();
        if(!name.trim().isEmpty()){
            e.setName(name);
        }
        System.out.println("nhap gia san pham");
        price = sc.nextLine();
        if(!price.trim().isEmpty()){
            e.setPrice(price);
        }
        System.out.println("nhap thong so san pham");
        value = sc.nextInt();
        sc.nextLine();
        if(value>0 || !Integer.toString(value).trim().isEmpty()){
            e.setSpecification(value);
        }
        System.out.println("san pham sau khi sua");
        System.out.println(e.disPlayInfo());
    }

    public static void main(String[] args) {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        List<Entity>Elist = new ArrayList<>();

        while (loop) {
            menu();
            int action;
            action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    Elist.add(createP(sc, 0));
                    break;
                case 1:
                    Elist.add(createP(sc, 1));
                    break;
                case 2:
                    update(sc, Elist);
                    break;
                case 3:
                    delete(sc, Elist);
                    break;
                case 4:
                    outphy(Elist);
                    break;
                case 5:
                    outdig(Elist);
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    System.out.println("lua chon khong hop le");
                    break;
            }
        }
    }

    public static abstract class Entity {
        private String id;
        private String name;
        private String price;

        public Entity(String name, String price) {
            this.name = name;
            this.price = price;
        }

        protected void setID(String id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public String getprice() {
            return this.price;
        }

        public void setName(String name){
            this.name = name;
        }

        public void setPrice(String price){
            this.price = price;
        }

        abstract public void setSpecification(int value);
        abstract public String disPlayInfo();
    }

    public static class PhysicalProduct extends Entity {
        private int weight;
        private static int quantity = 0;

        public PhysicalProduct(int weight, String name, String price) {
            super(name, price);
            this.weight = weight;
            this.setID("sp_phy_".concat(Integer.toString(quantity + 1)));
            quantity++;
        }

        public String disPlayInfo() {
            return "id: "+super.id+"name: " + this.getName() + " price: " + this.getprice() + " weight: " + this.weight;
        }

        public void setSpecification(int weight){
            this.weight = weight;
        }
    }

    public static class DigitalProduct extends Entity {

        private String size;
        private static int quantity = 0;

        public DigitalProduct(int size, String name, String price) {
            super(name, price);
            this.size = Integer.toString(size);
            this.setID("sp_dig_".concat(Integer.toString(quantity + 1)));
            quantity++;
        }

        public String disPlayInfo() {
            return "id: "+super.id+"name: " + this.getName() + " price: " + this.getprice() + " size: " + this.size;
        }

        public void setSpecification(int size){
            this.size = Integer.toString(size);
        }
    }

    public static class ProductFactory {

        public static Entity createProduct(String type, String name, String price, int value) {
            if (type.equalsIgnoreCase("physical")) {
                return new PhysicalProduct(value, name, price);
            } else if (type.equalsIgnoreCase("digital")) {
                return new DigitalProduct(value, name, price);
            } else {
                System.out.println("Loai san pham khong hop le!");
                return null;
            }
        }
    }

}
