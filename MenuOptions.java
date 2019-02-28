import javaa.util.HashMap;

public class MenuOptions extends UserData{
  HashMap<String, UserData> menuChoices = new HashMap<String, UserData>();
  menuOptions.put("Show Budget Overview", Budget.getBudget);
}
