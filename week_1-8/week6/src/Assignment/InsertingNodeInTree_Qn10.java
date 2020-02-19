package Assignment;


class InsertingNodeInTree_Qn10 {
    class NewNode {
        int key;
        NewNode leftside, rightside;

        public NewNode(int item) {
            key = item;
            leftside = rightside = null;
        }
    }

    NewNode starttree;

   private InsertingNodeInTree_Qn10() {
        starttree = null;
    }
    void insert(int key) {
        starttree = insertRec(starttree, key);
    }

    NewNode insertRec(NewNode starttree, int key) {
        if (starttree == null) {
            starttree = new NewNode(key);
            return starttree;
        }
        if (key < starttree.key)
            starttree.leftside = insertRec(starttree.leftside, key);
        else if (key > starttree.key)
            starttree.rightside = insertRec(starttree.rightside, key);
        return starttree;
    }



    public static void main(String[] args) {
        InsertingNodeInTree_Qn10 tree = new InsertingNodeInTree_Qn10();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();

    }

    void inorder()  {
        inorderRec(starttree);
    }
    void inorderRec(NewNode root) {
        if (root != null) {
            inorderRec(root.leftside);
            System.out.println(root.key);
            inorderRec(root.rightside);
        }
    }
}