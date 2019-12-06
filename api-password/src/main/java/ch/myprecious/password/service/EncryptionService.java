package ch.myprecious.password.service;

public interface EncryptionService {

  byte[] encrypt(String masterPassword, String childPassword);

  String decrypt(String masterPassword, byte[] encryptedChildPassword);
}
