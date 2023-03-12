package EncryptionProgram;

import java.util.*;

public class EncryptionProgram {


    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;



    EncryptionProgram(){
       scanner = new Scanner(System.in);// ameebit initializacias vuketebt cvladebs
       random = new Random();
       list = new ArrayList<>();
       shuffledList= new ArrayList<>();
       character= ' ';

       newKey(); // aq rom movalt ukve shegvilia sheqmna axali keys anu vidzaxebt am metodebs
       askQuestion();




    }

    private void askQuestion(){
        while(true){
            System.out.println("******************************************************");
            System.out.println("what do you want to do?");
            System.out.println("(N)ewKey , (G)etKey , (E)ncrypt, (D)ecrypt , (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0)); // amit vigebt momxmareblis responses

            switch (response){ // amit vafasebt rac momxmarebelma chawera da vubrunebt funqcias rasac moitxovs

                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default :
                    System.out.println("not a valid answer! :(");
            }
        }

    }
    private void newKey(){
        character= ' '; // amit vambobt rom pirveli characteri aris space anu 32 ascii cxrilshi
        list.clear(); // amit vwmindavt lists da shuffled lists ro araferi ar iyos shignit
        shuffledList.clear();

        for(int i=32; i<127; i++){
            list.add(Character.valueOf(character));
            character++;// am funqciit vumatebt characters anu xdeba 33 , 34 ... anu characteri tvitonac icvleba ascii cxrilis mixedvit
        }

        shuffledList = new ArrayList<>(list);// akopirebs lists
        Collections.shuffle(shuffledList); // es chashenebuli metodi shuffles list
        System.out.println("new key has been generated");


    }
    private void getKey(){
        System.out.println("key: ");
        for(Character x : list){
            System.out.print(x);
        }
        System.out.println();
        for(Character x : shuffledList){
            System.out.print(x);
        }
        System.out.println();

    }
    private void encrypt(){
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();
        System.out.println(letters);


        for( int i = 0 ; i<letters.length; i++){

            for( int j = 0 ; j<list.size(); j++){
                  if(letters[i]==list.get(j)){ // amit vamowmebt chveulebriv listshi meramdenea mesijis aso
                      letters[i] = shuffledList.get(j);// amit mag mesijis asws vanichebt shuffled listshi shesabamis asos
                      break;
                  }
            }
        }
        System.out.println("encrupted: ");
        String encryptedMessage = "";
        for(char x :letters){

            System.out.print(x);
        }
//        System.out.println(encryptedMessage);// amit ubralod vachvenebt rgori mesiji gaxda
        System.out.println();

    }
    private void decrypt(){
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();
        System.out.println(letters);


        for( int i = 0 ; i<letters.length; i++){

            for( int j = 0 ; j<shuffledList.size(); j++){
                if(letters[i]==shuffledList.get(j)){ // amit vamowmebt chveulebriv listshi meramdenea mesijis aso
                    letters[i] =list.get(j);// amit mag mesijis asws vanichebt shuffled listshi shesabamis asos
                    break;
                }
            }
        }
        System.out.println("Decrupted: ");

        for(char x :letters){

            System.out.print(x);
        }
//
        System.out.println();

    }
    private void quit(){
        System.out.println("thankl you have a nice day bro");
        System.exit(0);

    }


}
