package assignment2;
public class CartList {
    private CartNode head;
    private int size = 0;

    public void addItem(Product p, int qty) {
        CartNode current=head;
        while (current!=null) {
            if (current.product.getId()==p.getId()) {
                current.quantity+=qty;
                return;
            }
            current = current.next;
        }

        CartNode newNode=new CartNode(p, qty);
        newNode.next=head;
        head=newNode;
        size++;
    }
    
    public CartNode removeItem(int productId) {
        if (head==null) return null;

        if (head.product.getId()==productId) {
            CartNode temp=head;
            head=head.next;
            size--;
            return temp; 
        }

        CartNode current=head;
        while (current.next!=null) {
            if (current.next.product.getId()==productId) {
                CartNode temp=current.next;
                current.next=current.next.next;
                size--;
                return temp; 
            }
            current=current.next;
        }
        return null;
    }
    
    public void updateQuantity(int productId, int newQty) {
        CartNode current=head;
        while (current!=null) {
            if (current.product.getId()==productId) {
                int difference=newQty-current.quantity;

                if (current.product.getStock()>=difference) {
                    current.product.setStock(current.product.getStock()-difference);
                    current.quantity=newQty;
                    System.out.println("Quantity updated.");
                } else {
                    System.out.println("Insufficient stock to increase quantity!");
                }
                return;
            }
            current=current.next;
        }
        System.out.println("Product not found in cart.");
    }
    
    public CartNode findItem(int productId) {
        CartNode current = head;
        while (current != null) {
            if (current.product.getId() == productId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayCart() {
        CartNode temp=head;
        double total=0;
        System.out.println("--- Your Cart ---");
        while (temp!=null) {
            double subtotal=temp.product.getPrice() * temp.quantity;
            System.out.printf("%s x%d - Subtotal: %.2f\n", temp.product.getName(), temp.quantity, subtotal);
            total+=subtotal;
            temp=temp.next;
        }
        System.out.printf("Total: %.2f\n", total);
    }
    
    public double calculateTotal() {
        double total=0;
        CartNode current=head;
        while (current!=null) {
            total+=(current.product.getPrice()*current.quantity); 
            current=current.next;
        }
        return total;
    }

    public void clear() { head=null; size=0; }
    
    public void undo() {
        if (head==null) {
            System.out.println("Nothing to undo!");
            return;
        }

        head.product.setStock(head.product.getStock()+head.quantity);

        System.out.println("Undo successful: Removed "+head.product.getName());
        head=head.next;
        size--;
    }
    
    public int getSize() {
        return size; 
    }
    
    public boolean isEmpty() {
        return head==null;
    }
}