import java.io.*;
import java.util.*;
import model.*;


public class HomeWork8_2 {
    public static List<Account> getAccount(Client client, List<Account> accounts){
        ArrayList<Account> allAccount = new ArrayList<>(100);
        Iterator<Account> iter=accounts.iterator();
        while (iter.hasNext()){
            Account element=iter.next();
            if(client.equals(element.getClient())){
                allAccount.add(element);
            }
        }
        return allAccount;
    }
    public  static String readLN(BufferedReader reader){
        String indexAnswer="";
        try {
            indexAnswer = reader.readLine();
            return indexAnswer;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Account> accounts = new ArrayList<>();
        HashMap<String, Client> clients = new HashMap<>();
        HashMap<String, Client> searchClient = new HashMap<>();
        System.out.println("Для заполнения данных по клиентам и счетам восользуйтесь кнопками:\n" +
                "1: Введите данные клиента\n" +
                "2: Введите данные счета \n" +
                "3: Вывод всех счетов клиента\n" +
                "4: Поиск клиента по счету\n" +
                "5: Выход из программы");
        String commandNumber;
        String name;
        String age;
        String id;
        Client client=null;
        Client clientSearch=null;
        Boolean clientAdd=false;
        while(true){
            System.out.println("Введите команду");
            commandNumber=readLN(reader);
            switch (commandNumber){
                case "1":
                    System.out.println("Введите имя клиента");
                    name=readLN(reader);
                    System.out.println("Введите возраст клиента");
                    age=readLN(reader);
                    System.out.println("Введите ID клиента");
                    id=readLN(reader);
                    client=new Client(name,id,age);
                    clientAdd=true;
                    clients.put(id, client);
                    break;
                case "2":
                    if(!clientAdd){
                        System.out.println("Введите имя клиента");
                        name=readLN(reader);
                        System.out.println("Введите возраст клиента");
                        age=readLN(reader);
                        System.out.println("Введите ID клиента");
                        id=readLN(reader);
                        client=new Client(name,id,age);
                        clientAdd=true;
                    }
                    System.out.println("Введите номер счета");
                    String accNumber=readLN(reader);
                    Account account=new Account(client,accNumber);
                    accounts.add(account);
                    searchClient.put(accNumber, client);
                    break;
                case "3":
                    System.out.println("Вывод всех счетов для клиента с ID:");
                    String idSearch=readLN(reader);
                    clientSearch=clients.get(idSearch);
                    accounts.stream().filter(a->a.getClient().getId().equals(idSearch)).forEach(a-> System.out.println(a.getAccountNumber()));
                   /* List allAccaunts=getAccount(clientSearch,accounts);
                    Iterator<Account> iter=allAccaunts.iterator();
                    System.out.println("Список счетов клиента: 1");
                    while (iter.hasNext()){
                        Account element=iter.next();
                        System.out.println(element.getAccountNumber());
                    }*/
                    break;
                case "4":
                    System.out.println("Поиск клиента по номеру счета. Введите счет:");
                    String accSearch=readLN(reader);
                    System.out.println(searchClient.get(accSearch).getName());
                    break;
                default:
                    break;
            }
           if (commandNumber.equals("5")) break;
        }
    }
}