package Main;

/**
 * Created by Александр on 11.05.2017.
 */
public class SearchResult {
    String path;
    boolean found;

    public SearchResult()
    {
        path ="";
        found=false;
    }

    public SearchResult(String _path, boolean _found) {
        path = _path;
        found = _found;
    }

    public String Print()
    {
        if(found)
            return "Файл найден: "+path;
        else
            return "Файл не найден";
    }
}
