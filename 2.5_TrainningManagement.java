import java.util.Arrays;
import java.util.Scanner;

public class TrainningManagement {
    private final TraineeForm traineeForm;
    private final Scanner scanner;
    private final Trainee[] listOfTrainees = new Trainee[100];
    private byte count = 0;

    public TrainningManagement(){
        this.scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(scanner);
    }

    public static void main(String[] args) {
        new TrainningManagement().runMenu();
    }

    private void runMenu(){
        while(true){
            System.out.println("\n======= Trainee Management =======");
            System.out.println("1. Add trainees");
            System.out.println("2. Display all traineess");
            System.out.println("3. Find trainee by id");
            System.out.println("4. Find trainee by name");
            System.out.println("5. Update trainee by id");
            System.out.println("0. Exit");
            System.out.println("Choose");
            String choice = scanner.nextLine().trim();

            switch (choice){
                case "1" -> addTrainee();
                case "2" -> displayAllTrainees();
                case "3" ->{
                    System.out.println("Enter id to find: ");
                    String id = scanner.nextLine().trim();

                    Trainee trainee = findTraineeById(id);
                    System.out.println(trainee != null?header()+"\n"+trainee:"Not found");
                }
                case "4" ->{
                    System.out.println("Enter name (Keyword): ");
                    String name = scanner.nextLine().trim();

                    Trainee[] result = findTraineeByName(name);
                    if (result.length == 0) System.out.println("No match");
                    else{
                        System.out.println(header());
                        for (Trainee t : result) System.out.println(t);
                    }
                }
                case "5" ->{
                    System.out.println("Enter id to update: ");
                    String id = scanner.nextLine().trim();

                    Trainee newTrainee = traineeForm.getTrainee();
                    updateTrainee(id, newTrainee);
                }
                case "0" -> {System.out.println("Bye!"); return;}
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public void addTrainee(){
        if(count >= listOfTrainees.length){
            System.out.println("Storage full!");
            return;
        }
        String id;
        while (true){
            id = traineeForm.getId();
            if(indexOfId(id) == -1) break;
            System.out.println("Id already exits. Enter another.");
        }
        Trainee trainee = traineeForm.getTrainee();
        trainee.setId(id);
        listOfTrainees[count++] = trainee;

        System.out.println("Created successfully!");
    }

    public void displayAllTrainees(){
        if(count == 0){
            System.out.println("No trainees yet.");
            return;
        }
        System.out.println(header());
        for(int i=0; i< count; i++){
            System.out.println(listOfTrainees[i]);
        }
    }

    public Trainee findTraineeById(String id){
        int idx = indexOfId(id);
        return idx == -1? null: listOfTrainees[idx];
    }

    public Trainee[] findTraineeByName(String name){
        if(name == null || name.trim().isEmpty()){
            return new Trainee[0];
        }
        String key = name.toLowerCase();
        Trainee[] temp = new Trainee[count];
        int k = 0;

        for(int i = 0; i< count; i++){
            if(listOfTrainees[i] != null && listOfTrainees[i].getName() != null){
                if(listOfTrainees[i].getName().toLowerCase().contains(key)){
                    temp[k++]=listOfTrainees[i];
                }
            }
        }

        return Arrays.copyOf(temp,k);
    }

    public void updateTrainee(String id, Trainee newTrainee){
        int idx = indexOfId(id);
        if(idx == -1){
            System.out.println("Id not found. ");
            return;
        }
        listOfTrainees[idx].setName(newTrainee.getName());
        listOfTrainees[idx].setGender(newTrainee.getGender());
        listOfTrainees[idx].setAge(newTrainee.getAge());

        System.out.println("Updated");
    }

    private int indexOfId(String id){
        for(int i=0; i< count; i++){
            if(listOfTrainees[i].getId().equalsIgnoreCase(id)) return  i;
        }
        return -1;
    }

    private String header(){
        return String.format("%-8s | %-18s | %-6s | %-3s", "ID","NAME","SEX","AGE");
    }
}
