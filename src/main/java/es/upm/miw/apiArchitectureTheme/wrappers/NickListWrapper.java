package es.upm.miw.apiArchitectureTheme.wrappers;

import java.util.ArrayList;
import java.util.List;

public class NickListWrapper {
	
    List<NickWrapper> nickList;
	
	public NickListWrapper()
	{
		nickList=new ArrayList<>();
	}
	
	public List<NickWrapper> getNickList()
	{
		return nickList;
	}
	
	public void addNickWrapper (NickWrapper nickWrapper)
	{
		nickList.add(nickWrapper);
	}
	
	public String toString() {
		String result = "{\"nickList\":[ ";
		for (NickWrapper nickWrapper : nickList) {
			result += nickWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
