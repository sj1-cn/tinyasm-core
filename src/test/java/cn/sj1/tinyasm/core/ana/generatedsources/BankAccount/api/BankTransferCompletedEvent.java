package cn.sj1.tinyasm.core.ana.generatedsources.BankAccount.api;

public class BankTransferCompletedEvent
{
  private String bankTransferId;
  
  public BankTransferCompletedEvent(String bankTransferId)
  {
    this.bankTransferId = bankTransferId;
  }
  
  public String getBankTransferId()
  {
    return this.bankTransferId;
  }
  
  public String toString(String bankTransferId)
  {
    return "BankTransferCompletedEvent(" + "bankTransferId=" + this.bankTransferId + ")";
  }
}
