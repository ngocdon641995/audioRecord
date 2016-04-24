package myclass;

public class AudioFile {
	
	private String _filename;
	private String _dateRecord;
	private String _timeRecord;
	private int size;
	private int lenght;
	public AudioFile(String _filename, String _dateRecord, String _timeRecord, int size, int lenght) {
		this._filename = _filename;
		this._dateRecord = _dateRecord;
		this._timeRecord = _timeRecord;
		this.size = size;
		this.lenght = lenght;
	}
	public String get_filename() {
		return _filename;
	}
	public void set_filename(String _filename) {
		this._filename = _filename;
	}
	public String get_dateRecord() {
		return _dateRecord;
	}
	public void set_dateRecord(String _dateRecord) {
		this._dateRecord = _dateRecord;
	}
	public String get_timeRecord() {
		return _timeRecord;
	}
	public void set_timeRecord(String _timeRecord) {
		this._timeRecord = _timeRecord;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
	

	
	
}
