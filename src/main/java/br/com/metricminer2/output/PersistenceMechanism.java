package br.com.metricminer2.output;

public interface PersistenceMechanism {
	void write(Object... line);
	void close();
}
