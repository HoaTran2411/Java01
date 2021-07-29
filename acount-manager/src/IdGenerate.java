import java.util.List;

public class IdGenerate {

    public static Long getId(List<User> usersList){
        //tìm ra id lớn nhất trong dãy:
        long maxId = 0;
        for (int i = 0; i < usersList.size(); i++){
            if (usersList.get(i).getId() > maxId){
                maxId = usersList.get(i).getId();
            }
        }
        return maxId + 1;
    }
}
