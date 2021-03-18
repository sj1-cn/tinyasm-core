package cn.sj1.tinyasm.core.ana.generatedsources.BankAccount.api;

public class BankTransferFailedEvent
{
  private String bankTransferId;
  
  public BankTransferFailedEvent(String bankTransferId)
  {
    this.bankTransferId = bankTransferId;
  }
  
  public String getBankTransferId()
  {
    return this.bankTransferId;
  }
  
  public String toString(String bankTransferId)
  {
    return "BankTransferFailedEvent(" + "bankTransferId=" + this.bankTransferId + ")";
  }
}
