package nebula.tinyasm.ana.generatedsources.BankAccount.api;

public class BankTransferMarkFailedCommand
{
  private String bankTransferId;
  
  public BankTransferMarkFailedCommand(String bankTransferId)
  {
    this.bankTransferId = bankTransferId;
  }
  
  public String getBankTransferId()
  {
    return this.bankTransferId;
  }
  
  public String toString(String bankTransferId)
  {
    return "BankTransferMarkFailedCommand(" + "bankTransferId=" + this.bankTransferId + ")";
  }
}
