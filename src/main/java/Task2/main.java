package Task2;

public class main {




    public static void main(String[] args) {
        Repository repository = new Repository();
        repository.importData();
//        repository.printTop(5);
        System.out.println(repository.getTotalValueOfCategory("men's clothing"));

        System.out.println(repository.getHighestValueCustomer());



    }
}
