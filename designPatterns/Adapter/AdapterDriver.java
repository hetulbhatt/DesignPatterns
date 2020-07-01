import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

class Adaptee{
	Hashtable<String,Integer> files;

	Adaptee(){
		files = new Hashtable<String,Integer>();
	}

	public void setFiles(String file, int size){
		files.put(file,size);
	}

	public Hashtable<String,Integer> getFiles(){
		return files;
	}
}

interface Target{
	public String report();
}

class Adapter implements Target{
	Adaptee fileAdaptee;
	Iterator itr;

	public Adapter(Adaptee adaptee){
		this.fileAdaptee = adaptee;
		itr = fileAdaptee.getFiles().entrySet().iterator();
	}

	public String report(){
		Map.Entry entry;
		String buffer = "";
		float temp;

		while(itr.hasNext()){
			entry = (Map.Entry)itr.next();
			temp = (int)entry.getValue();
			String unit = "KB";
			if (temp>1024){
				temp = temp/1024;
				unit = "MB";
				if(temp>1024){
					temp = temp/1024;
					unit = "GB";
				}
			}
			buffer+="Size of the file "+entry.getKey()+" is "+temp+" "+unit+"\n";
		}
		return buffer;
	}
}

class Adapter2 implements Target{
	Adaptee fileAdaptee;
	Iterator itr;

	public Adapter2(Adaptee adaptee){
		this.fileAdaptee = adaptee;
		itr = fileAdaptee.getFiles().entrySet().iterator();
	}

	public String report(){
		Map.Entry entry;
		float temp = 0;
		while(itr.hasNext()){
			entry = (Map.Entry)itr.next();
			temp += (int)entry.getValue();
		}
		String unit = "KB";
		if (temp>1024){
			temp = temp/1024;
			unit = "MB";
			if(temp>1024){
				temp = temp/1024;
				unit = "GB";
			}
		}
		String buffer = "Total size of all files is: "+temp+" "+unit+"\n";
		return buffer;
	}
}

public class AdapterDriver{
	public static void main(String[] args) {
		Adaptee files = new Adaptee();
		files.setFiles("Socrates.pdf",119202);
		files.setFiles("Music.mp3",24093);
		files.setFiles("Cars.mp4",2234096);
		files.setFiles("Index.html",192);

		Target fileAdpter = new Adapter(files);
		System.out.println(fileAdpter.report());
		Target fileAdpter2 = new Adapter2(files);
		System.out.println(fileAdpter2.report());
	}
}