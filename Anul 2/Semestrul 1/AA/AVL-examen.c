#include <stdio.h>
#include <stdlib.h>

struct node
{
    int value; 
    struct node* right;    
    struct node* left;
};

int inaltime(struct node* node) {
    /* base case tree is empty */
    if (node == NULL)
        return 0;

    /* If tree is not empty then height = 1 + max of left
     height and right heights */
    return 1 + max(inaltime(node->left), inaltime(node->right));
}

struct node* search(struct node* root, int key)
{
    if (root == NULL || root->value == key) //if root->value is key then the element is found
        return root;
    else if (key > root->value) // key is greater, so we will search the right subtree
        return search(root->right, key);
    else //key is smaller than the value, so we will search the left subtree
        return search(root->left, key);
}

struct node* find_minimum(struct node* root)
{
    if (root == NULL)
        return NULL;
    else if (root->left != NULL) // node with minimum value will have no left child
        return find_minimum(root->left); // left most element will be minimum
    return root;
}

int AVL(struct node* root) {
    int lh, rh;
    if (root == NULL)
        return -1;
    lh = inaltime(root->left);
    rh = inaltime(root->right);
    if (abs(lh-rh)<=1 && AVL(root->left) && AVL(root->right))
        return 1;
    return 0;
}

int perfect(struct node* root) {
    int lh, rh;
    if (root == NULL)
        return -1;
    lh = inaltime(root->left);
    rh = inaltime(root->right);
    if ((lh==rh) && AVL(root->left) && AVL(root->right))
        return 1;
    return 0;
}

//function to create a node
struct node* new_node(int key)
{
    struct node* p;
    p = malloc(sizeof(struct node));
    p-> value= key;
    p->left = NULL;
    p->right = NULL;

    return p;
}

struct node* insert(struct node* root, int key)
{
    //searching for the place to insert
    if (root == NULL)
        return new_node(key);
    else if (key > root->value) { // key is greater. Should be inserted to right
        root->right = insert(root->right, key);
        //  root->right->ech = inaltime(root->right->left) - inaltime(root->right->right);
    }
    else if (key < root->value) { // key is smaller should be inserted to left
        root->left = insert(root->left, key);
        //root->left->ech = inaltime(root->left->left) - inaltime(root->left->right);
    }
    else
        return root;
    return root;
    
}

// funnction to delete a node
struct node* sterge(struct node* root, int key)
{
    //searching for the item to be deleted
    if (root == NULL)
        return NULL;
    if (key > root->value)
        root->right = sterge(root->right, key);
    else if (key < root->value)
        root->left = sterge(root->left, key);
    else
    {
        //No Children
        if (root->left == NULL && root->right == NULL)
        {
            free(root);
            return NULL;
        }

        //One Child
        else if (root->left == NULL || root->right == NULL)
        {
            struct node* temp;
            if (root->left == NULL)
                temp = root->right;
            else
                temp = root->left;
            free(root);
            return temp;
        }

        //Two Children
        else
        {
            struct node* temp = find_minimum(root->right);
            root->value = temp->value;
            root->right = sterge(root->right, temp->value);
        }
    }
    return root;
}

void inOrder(struct node* root)
{
    if (root != NULL) // checking if the root is not null
    {
        inOrder(root->left); // visiting left child
        printf(" %d ", root->value); // printing value at root
        inOrder(root->right);// visiting right child
    }
}

void preOrder(struct node* root) {
    if (root != NULL) {
        printf("%d ", root->value);
        preOrder(root->left);
        preOrder(root->right);
    }
}

void postOrder(struct node* root) {
    if (root != NULL) {
        postOrder(root->left);
        postOrder(root->right);
        printf("%d ", root->value);
    }
}



int main()
{
    struct node* root=NULL;
    int v[15] = { 12,-7,45,32,2,22,1,2,3,4,9,90,89,225,0 };
    int i;
    int opt;
    while (1) {
        printf("\n1.Setare valori arbor.");
        printf("\n2.Stergere valori pare din arbor.");
        printf("\n3.Afisare arbor.");
        printf("\n4.Verificare AVL si perfect echilibru.");
        printf("\n5.Iesire.");
        printf("\nOptiunea dorita: ");
        scanf("%d", &opt);
        switch (opt)
        {
        case 1:
            root = new_node(v[0]);
            for (i = 1; i < 15; i++)
                insert(root, v[i]);
            break;
        case 2:
            for (i = 0; i < 15; i++)
                if (v[i] % 2 == 0)
                    root = sterge(root, v[i]);
            break;
        case 3:
            inOrder(root);
            printf("\n");
            preOrder(root); 
            printf("\n");
            postOrder(root);
            printf("\n");
            break;
        case 4:
            if (AVL(root))
                printf("\nEchilibrat in sens AVL.\n");
            else
                printf("\nNu este echilibrat in sens AVL.\n");
            if(perfect(root))
                printf("\nPerfect echilibrat.\n");
            else
                printf("\nNu este perfect echilibrat.\n");
            break;
        case 5:
            exit(0);
            break;
        default:
            printf("Optiune gresita!");
            break;
        }

    }
}