import java.util.*;

public class PhoneContacts {
    private Map<String, List<Contact>> phoneContacts = new HashMap<>();

    protected void createGroup(String group) {
        phoneContacts.put(group, new ArrayList());
    }

    protected void addContactToGroups(Contact contact, String[] groups) {
         try {
             for (String group : groups) {
                 phoneContacts.get(group).add(contact);
             }
         } catch (NullPointerException exception) {
             System.out.println("Такой группы не существует - " + exception.getMessage());
         }
    }

    //Добавил методы
    protected Set<String> getGroups() {
        Set<String> setOfKey = phoneContacts.keySet();
        return setOfKey;
    }

    protected List<Contact> getСontacts(String group) {
         List<Contact> temp = phoneContacts.get(group);
         return temp;
    }
}
