package ch.myprecious.common.services;

public interface HashingService {

  byte[] getSalt();

  byte[] getHashedPassword(String clearTextPassword, byte[] salt);

}
