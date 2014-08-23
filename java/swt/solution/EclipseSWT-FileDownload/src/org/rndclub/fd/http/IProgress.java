package org.rndclub.fd.http;

public interface IProgress {

	public void init(int total);

	public void initStatge(int init, int max);

	public void incP(int i);

	public void finish();
}
