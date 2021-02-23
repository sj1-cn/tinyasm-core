package cc1sj.tinyasm.ana.generatedsources.BankAccount.api;

public class BankTransferMarkCompletedCommand
{
  private String bankTransferId;
  
  public BankTransferMarkCompletedCommand(String bankTransferId)
  {
    this.bankTransferId = bankTransferId;
  }
  
  public String getBankTransferId()
  {
    return this.bankTransferId;
  }
  
  public String toString(String bankTransferId)
  {
    return "BankTransferMarkCompletedCommand(" + "bankTransferId=" + this.bankTransferId + ")";
  }
}
