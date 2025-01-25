import java.util.*;
import java.time.*;

class Ifriendcontact {
	
    public static String idArray[] = new String[0];
    public static String nameArray[] = new String[0];
    public static String birthdayArray[] = new String[0];
    public static String phoneArray[] = new String[0];
    public static String companyArray[] = new String[0];
    public static int salaryArray[] = new int[0];

    public static void extendArray() {
        String tempidArray[] = new String[idArray.length + 1];
        String tempnameArray[] = new String[nameArray.length + 1];
        String tempbirthdayArray[] = new String[birthdayArray.length + 1];
        String tempphoneArray[] = new String[phoneArray.length + 1];
        String tempcompanyArray[] = new String[companyArray.length + 1];
        int tempsalaryArray[] = new int[salaryArray.length + 1];

        for (int i = 0; i < idArray.length; i++) {
            tempidArray[i] = idArray[i];
            tempnameArray[i] = nameArray[i];
            tempbirthdayArray[i] = birthdayArray[i];
            tempphoneArray[i] = phoneArray[i];
            tempcompanyArray[i] = companyArray[i];
            tempsalaryArray[i] = salaryArray[i];
        }
        idArray = tempidArray;
        nameArray = tempnameArray;
        birthdayArray = tempbirthdayArray;
        phoneArray = tempphoneArray;
        companyArray = tempcompanyArray;
        salaryArray = tempsalaryArray;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void homepage() {
        Scanner input = new Scanner(System.in);
		System.out.println("			 /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$");
		System.out.println("			|__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
		System.out.println("			 /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$");
		System.out.println("			| $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$");
		System.out.println("			| $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$");
		System.out.println("			| $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$");
		System.out.println("			| $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
		System.out.println("			|__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/ ");
		System.out.println();
		System.out.println();
        System.out.println("		   _____            _             _          ____                        _              ");
		System.out.println("		  / ____|          | |           | |        / __ \\                      (_)             ");
		System.out.println("		 | |     ___  _ __ | |_ __ _  ___| |_ ___  | |  | |_ __ __ _  __ _ _ __  _ _______ _ __ ");
		System.out.println("		 | |    / _ \\| '_ \\| __/ _` |/ __| __/ __| | |  | | '__/ _` |/ _` | '_ \\| |_  / _ \\ '__|");
		System.out.println("		 | |___| (_) | | | | || (_| | (__| |_\\__ \\ | |__| | | | (_| | (_| | | | | |/ /  __/ |   ");
		System.out.println("		  \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/  \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|   ");
		System.out.println("		                                                       |___/                            ");
                            
        System.out.println("\n [01] ADD Contacts ");
        System.out.println("\n [02] UPDATE Contacts ");
        System.out.println("\n [03] DELETE Contacts ");
        System.out.println("\n [04] SEARCH Contacts ");
        System.out.println("\n [05] LIST Contacts ");
        System.out.println("\n [06] Exit");
        System.out.print("\n Enter an option to continue ->");

        int option = input.nextInt();

        switch (option) {
            case 1:
                addcontact();
                break;
            case 2:
                updatecontact();
                break;
            case 3:
                deletecontact();
                break;
            case 4:
				searchcontact();
				break;
			case 5:
				listcontact();
				break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid Input! Please try again.");
                homepage();
        }
    }

    public static boolean isvalidphone(String no) {
        if (no.charAt(0) == '0' && no.length() == 10) {
            for (int i = 1; i < no.length(); i++) {
                if (!Character.isDigit(no.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isvalidBirthday(String birthday) {
 		String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		
		LocalDate currentDate=LocalDate.now();
		int currentyear=currentDate.getYear();
		int currentmonth=currentDate.getMonthValue();
		int currentday=currentDate.getDayOfMonth();
		if (month <1||month>12) {
			return false;
		}
		
		if (month==2) { 
			boolean isLeapYear=(year%4==0 && year%100!=0) || (year%400==0);
			if (isLeapYear && day>29) {
				return false;
			} else if (!isLeapYear && day>28) {
				return false;
			}
		} else if (month==4 || month==6 || month==9 || month==11) { 
			if (day>30) {
				return false;
			}
		} else { 
			if (day>31) {
				return false;
			}
		}

		if (year>currentyear) {
			return false;
		} else if (year==currentyear) {
			if (month>currentmonth) {
				return false;
			} else if (month==currentmonth && day>=currentday) {
				return false;
			}
		}

		return true;
	}

    public static String generatedId() {
        if (idArray.length == 0) {
            return "C0001";
        } else {
            String lastid = idArray[idArray.length - 1];
            int lastno = Integer.parseInt(lastid.substring(1));
            return String.format("C%03d", lastno + 1);
        }
    }
    public static void searchcontact(){
		Scanner input = new Scanner(System.in);
		 do{
			clearConsole();
			System.out.println(" +---------------------------------------------------------------+");
			System.out.println(" |                   SEARCH Contacts                             |");
			System.out.println(" +---------------------------------------------------------------+");
			System.out.print(" Search contact by Name or Phone Number - ");
			String search=input.next();
			int count=0;
			for (int i=0;i<idArray.length;i++){
				if(phoneArray[i].equals(search)){
					displayContact(i);
					break;
				}else if(nameArray[i].equals(search)){
					displayContact(i);
					break;
				}else{
					++count;
					if(count==1){
						System.out.printf("\tNo contact found for %-5s...",search);
					}
				}
			}
			System.out.print(" Do you want search another Contact (Y/N): ");
			
			char ch=input.next().charAt(0);
			
			if(ch=='Y' || ch=='y'){
					continue ;
			}else if(ch=='N' || ch=='n'){
				clearConsole();
				homepage();
				break;
			}
		}while(true);
	}

		
	public static void viweDetails() {
        System.out.println("+------------------------------------------------------------------------------------------------+");
        System.out.println("| Contact ID    |     Name      | Phone Number  |   Company     |    Salary     |   Birthday     |");
        System.out.println("+------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < idArray.length; i++) {
            System.out.printf("| %-13s | %-13s | %-13s | %-13s | %-13d | %-13s  |\n",
                    idArray[i],
                    nameArray[i],
                    phoneArray[i],
                    companyArray[i],
                    salaryArray[i],
                    birthdayArray[i]);
        }
        System.out.println("+------------------------------------------------------------------------------------------------+");
    }

	
	public static void sortingbyName(){
		clearConsole();
		System.out.println("+---------------------------------------+");
		System.out.println("|         List Contact by Name          |");
		System.out.println("+---------------------------------------+");
		
		for(int i=1;i<idArray.length;i++){
			for(int j=0;j<i;j++){
				String nameI=nameArray[i].toLowerCase();
				String nameJ=nameArray[j].toLowerCase();
				
				int chI=convername(nameI);
				int chJ=convername(nameJ);
				
				if(chJ>chI){
					sort(j,i);
				}else if(chJ==chI){
					int length=0;
					if(nameI.length()>nameI.length()){
						length=nameI.length();
					}else if(nameI.length()==nameI.length()){
						length=nameI.length();
					}else{
						length=nameJ.length();
					}
					for(int k=0;k<length;k++){
						if(nameI.charAt(k)!= nameJ.charAt(k)){
							chI=(int)nameI.charAt(k);
							chJ=(int)nameI.charAt(k);
						}
					}
					if(chJ>chI){
						sort(j,i);
					}	
				}
			}
		}
	}
	public static void sortingbySalary(){
		clearConsole();
		System.out.println("+---------------------------------------+");
		System.out.println("|         List Contact by Salary        |");
		System.out.println("+---------------------------------------+");
		
		for(int i=1;i<idArray.length;i++){
			for(int j=0;j<i;j++){
				if(salaryArray[j]>salaryArray[i]){
					sort(j,i);
				}
			}
		}
	}
	public static int convername(String name){
		char letter=name.charAt(0);
		int asValue=(int) letter;
		return asValue;
	}
	public static int covertYear(String birthday){
		String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		return year;
	}
	public static int covertMonth(String birthday){
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		return month;
	}
	public static int covertDay(String birthday){
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		return day;
	}

	public static void sortingbyBirthday(){
		clearConsole();
		System.out.println("+---------------------------------------+");
		System.out.println("|       List Contact by Birthday        |");
		System.out.println("+---------------------------------------+");
		
		for (int i = 1; i < idArray.length; i++) {
			for (int j = 0; j < i; j++) {
			
				String birthdayI=birthdayArray[i];
				String birthdayJ=birthdayArray[j];

				int yearI=covertYear(birthdayI);
				int yearJ=covertYear(birthdayJ);
				int monthI=covertMonth(birthdayI);
				int monthJ=covertMonth(birthdayJ);	
				int dayI = covertDay(birthdayI);
				int dayJ = covertDay(birthdayJ);	
						
				if (yearJ>yearI) {
					sort(j,i);	
				}else if (yearJ==yearI && monthJ>monthI) { 
					sort(j,i); 
					if (monthJ==monthI && dayJ>dayI) { 
						sort(j,i); 
					}
				}
			}
		}
	}
	public static void sort(int j,int i){
		String tempI=idArray[j];
		idArray[j]=idArray[i];
		idArray[i]=tempI;
		
		String tempN=nameArray[j];
		nameArray[j]=nameArray[i];
		nameArray[i]=tempN;
		
		String tempP=phoneArray[j];
		phoneArray[j]=phoneArray[i];
		phoneArray[i]=tempP;
		
		String tempB=birthdayArray[j];
		birthdayArray[j]=birthdayArray[i];
		birthdayArray[i]=tempB;
		
		String tempC=companyArray[j];
		companyArray[j]=companyArray[i];
		companyArray[i]=tempC;
		
		int tempS=salaryArray[j];
		salaryArray[j]=salaryArray[i];
		salaryArray[i]=tempS;
		
	}
	public static void removeTemp(String[] tempidArray,String[] tempnameArray,String[] tempphoneArray,String[] tempbirthdayArray,String[] tempcompanyArray,int[] tempsalaryArray){
			idArray=idArray;
			nameArray=tempnameArray;
			phoneArray=tempphoneArray;
			birthdayArray=tempbirthdayArray;
			companyArray=tempcompanyArray;
			salaryArray=tempsalaryArray;
	}
		
	public static void listcontact(){
		clearConsole();
		Scanner input = new Scanner(System.in);
		System.out.println("+-----------------------------------------------------------+");
		System.out.println("|              SEARCH Contact to the list                   |");
		System.out.println("+-----------------------------------------------------------+");
		
		System.out.println("\n\t[01] Short by Name");
        System.out.println("\n\t[02] Short by Salary");
        System.out.println("\n\t[03] Short by Birthday");
        System.out.print("\n\nEnter an option to continue -> ");
        int opt = input.nextInt();
        
        String tempidArray[]=new String[idArray.length];
		String tempnameArray[]=new String[nameArray.length];
		String tempbirthdayArray[]=new String[birthdayArray.length];
		String tempphoneArray[]=new String[phoneArray.length];
		String tempcompanyArray[]=new String[companyArray.length];
		int tempsalaryArray[]=new int[salaryArray.length];
		
		for(int i=0;i<idArray.length;i++){
			tempidArray[i]=idArray[i];
			tempnameArray[i]=nameArray[i];
			tempphoneArray[i]=phoneArray[i];
			tempbirthdayArray[i]=birthdayArray[i];
			tempcompanyArray[i]=companyArray[i];
			tempsalaryArray[i]=salaryArray[i];
		}
        
        switch (opt) {
            case 1:
				sortingbyName();
				viweDetails();
				removeTemp(tempidArray,tempnameArray,tempphoneArray,tempbirthdayArray,tempcompanyArray,tempsalaryArray);
				goToHome();
                break;
            case 2:
				sortingbySalary();
				viweDetails();
				removeTemp(tempidArray,tempnameArray,tempphoneArray,tempbirthdayArray,tempcompanyArray,tempsalaryArray);
				goToHome();
                break;
            case 3:
				sortingbyBirthday();
				viweDetails();
				removeTemp(tempidArray,tempnameArray,tempphoneArray,tempbirthdayArray,tempcompanyArray,tempsalaryArray);
				goToHome();
                break;
        }
	}

    public static void addcontact() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|         Add Contact to the list           |");
            System.out.println("+-------------------------------------------+");
            String id = generatedId();
            System.out.println();
            System.out.println(id);
            System.out.println("======");
			System.out.println();
            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Company Name: ");
            String company = input.nextLine();

            String birthday;
            do {
                System.out.print("B'Day (YYYY-MM-DD): ");
                birthday = input.nextLine();
                if (!isvalidBirthday(birthday)) {
                    System.out.println("Invalid birthday.");
                    System.out.print("Do you want to add another Contact? (Y/N): ");
                    char retry = input.nextLine().charAt(0);
                    if (retry == 'N' || retry == 'n') {
                        return;
                    }
                }
            } while (!isvalidBirthday(birthday));

            String no;
            do {
                System.out.print("Phone number: ");
                no = input.nextLine();
                if (!isvalidphone(no)) {
                    System.out.println("Invalid phone number.");
                    System.out.print("Do you want to try again? (Y/N): ");
                    char retry = input.nextLine().charAt(0);
                    if (retry == 'N' || retry == 'n')
                        return;
                }
            } while (!isvalidphone(no));

            System.out.print("Salary: ");
            int salary = input.nextInt();
            input.nextLine();

            extendArray();
            idArray[idArray.length - 1] = id;
            nameArray[nameArray.length - 1] = name;
            birthdayArray[birthdayArray.length - 1] = birthday;
            phoneArray[phoneArray.length - 1] = no;
            companyArray[companyArray.length - 1] = company;
            salaryArray[salaryArray.length - 1] = salary;

            System.out.println(" Added Successfully.");
            System.out.print(" Do you want to add another Contact? (Y/N): ");
            char ch = input.nextLine().charAt(0);

            if (ch == 'N' || ch == 'n') 
            break;

            clearConsole();
        } while (true);

        homepage();
    }
    public static void displayContact(int i) {
		System.out.println("\tContact ID        :"+idArray[i]);
		System.out.println("\tName              :"+nameArray[i]);
		System.out.println("\tPhone Number      :"+phoneArray[i]);
		System.out.println("\tCompany Name      :"+salaryArray[i]);
		System.out.println("\tSalary            :"+companyArray[i]);
		System.out.println("\tB'Day(YYYY-MM-DD) :"+birthdayArray[i]);
	}


    public static void updatecontact() {
		Scanner input = new Scanner(System.in);	
        L1: do{
			clearConsole();
			System.out.println(" +---------------------------------------------------------------+");
			System.out.println(" |                      UPDATE Contact                           |");
			System.out.println(" +---------------------------------------------------------------+");
			System.out.print("Search contact by Name or Phone Number - ");
			String update=input.next();
			int count=0;
			for (int i=0;i<idArray.length;i++){
				if(phoneArray[i].equals(update)){
					displayContact(i);
					newUpdateContact(i);
					System.out.println("\tContact has been update successfully...");
					break;
				}else if(nameArray[i].equals(update)){
					displayContact(i);
					newUpdateContact(i);
					System.out.println("\tContact has been update successfully...");
					break;
				}else{
					++count;
					if(count==1){
						System.out.printf("\tNo contact found for %-5s...",update);
					}
				}
			}
			
			System.out.print("\nDo you want add another Contact (Y/N): ");
			
			char ch=input.next().charAt(0);
			
			if(ch=='Y' || ch=='y'){
					continue L1;
			}else if(ch=='N' || ch=='n'){
				clearConsole();
				homepage();
				break;
			}
		}while(true);
	}
	public static void newUpdateContact(int i) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("\n\nWhat do you want to update...");
		System.out.println("\n\t[01] Name");
        System.out.println("\t[02] Phone Number");
        System.out.println("\t[03] Company Name");
        System.out.println("\t[04] Salary");
        
		System.out.print("\nEnter an option to continue -> ");
        int opt = input.nextInt();
		System.out.print("\033[9A");
		System.out.print("\033[0J");
        
        
        switch (opt) {
            case 1:
				System.out.println(" Update Name");
				System.out.println("=============");
				System.out.print("\nInput new name - ");
				String name=input.next();
                nameArray[i]=name;
               
                break;
            case 2:
				System.out.println(" Update Phone Number");
				System.out.println("=====================");
				System.out.print("\nInput new phone number - ");
				String phone=input.next();
                phoneArray[i]=phone;
                break;
            case 3:
				System.out.println(" Update Company Name");
				System.out.println("=====================");
				System.out.print("\nInput new company name - ");
				String company=input.next();
                companyArray[i]=company;
                break;
            case 4:
				System.out.println(" Update Salary");
				System.out.println("===============");
				System.out.print("\nInput new salary - ");
				int salary=input.nextInt();
                salaryArray[i]=salary;
                break;
            default:
                System.out.println(" Invalid option. Try again.");
        }
    }
    public static void delete(int i){
		for (int j=i;j<idArray.length-1;j++){
			idArray[j]=idArray[j+1];
			nameArray[j]=nameArray[j+1];
			phoneArray[j]=phoneArray[j+1];
			birthdayArray[j]=birthdayArray[j+1];
			companyArray[j]=companyArray[j+1];
			salaryArray[j]=salaryArray[j+1];
		}
		String tempidArray[]=new String[idArray.length-1];
		String tempnameArray[]=new String[nameArray.length-1];
		String tempbirthdayArray[]=new String[birthdayArray.length-1];
		String tempphoneArray[]=new String[phoneArray.length-1];
		String tempcompanyArray[]=new String[companyArray.length-1];
		int tempsalaryArray[]=new int[salaryArray.length-1];
		
		for(int j=0;j<idArray.length-1;j++){
				tempidArray[j]=idArray[j];
				tempnameArray[j]=nameArray[j];
				tempbirthdayArray[j]=birthdayArray[j];
				tempphoneArray[j]=phoneArray[j];
				tempcompanyArray[j]=companyArray[j];
				tempsalaryArray[j]=salaryArray[j];
		}
		idArray=tempidArray;
		nameArray=tempnameArray;
		birthdayArray=tempbirthdayArray;
		phoneArray=tempphoneArray;
		companyArray=tempcompanyArray;
		salaryArray=tempsalaryArray;
		
	}
    	public static void displayDeleteContact(int i){
		Scanner input = new Scanner(System.in);
		System.out.print("\nDo you want to delete this contact (Y/N):  - ");
		char ch=input.next().charAt(0);
			
		if(ch=='Y' || ch=='y'){
				delete(i);
				System.out.println("\tCustomer has been deleted successfully...");
		}else if(ch=='N' || ch=='n'){
			System.out.print("\nDo you want to delete this another contact (Y/N):  - ");
			char ch1=input.next().charAt(0);
			
			if(ch1=='Y' || ch1=='y'){
					deletecontact();
			}else if(ch1=='N' || ch1=='n'){
				homepage();
			}
		}
	}


    public static void deletecontact() {
		Scanner input = new Scanner(System.in);
       		do {
            clearConsole();
            System.out.println(" +---------------------------------------------------------------+");
            System.out.println(" |\t\t\tDELETE Contact \t\t\t\t|");
            System.out.println(" +----------------------------------------------------------------+\n\n");

            System.out.print("Search contact by Name or Phone Number - ");
            String delete = input.next();

            boolean found = false;

            for (int i = 0; i < idArray.length; i++) {
                if (phoneArray[i].equals(delete) || nameArray[i].equals(delete)) {
                    displayContact(i);
                    displayDeleteContact(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.printf("\n\tNo contact found for %-5s...", delete);
                System.out.print("\n\nDo you want to delete another contact? (Y/N): ");
                char ch1 = input.next().charAt(0);

                if (ch1 == 'N' || ch1 == 'n') {
                    homepage();
                    return; 
                }
            }
        } while (true);
    }
    public static void goToHome(){
		Scanner input = new Scanner(System.in);
		System.out.print(" Do you want go to home page (Y/N): ");
		char ch=input.next().charAt(0);
		if(ch=='Y' || ch=='y'){
			homepage();
		}
	}

    public static void main(String args[]) {
        homepage();
    }
}
