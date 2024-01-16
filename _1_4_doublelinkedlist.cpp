#include <iostream>
using namespace std;

struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

struct Pair {
    int start;
    int end;
};

void insertatfront(int data, struct Node*& head) {
    struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode->data = data;
    
    if(head == NULL) {
        head = newnode;
    } else {
        newnode->next = head;
        head->prev = newnode;
        head = newnode;
    }
    
}

void insertatlast(int data, struct Node*& head) {
    struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode->data = data;
    
    if(head == NULL) {
        head = newnode;
    } else {
        struct Node* temp = head;
        while(temp->next != NULL) {
            temp = temp->next;
        }
        
        newnode->prev = temp;
        temp->next = newnode;
    }
}

void insertatany(int data, struct Node*& head, int pos) {
    struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode->data = data;
    
    if(head == NULL) {
        head = newnode;
    } else {
        struct Node* temp = head;
        for(int i = 1; i < pos - 1; i++) {
            temp = temp->next;
        }
        
        newnode->next = temp->next;
        struct Node* curr = temp->next;
        curr->prev = newnode;
        temp->next = newnode;
        newnode->prev = temp;
    }
}

void deleteatfront(struct Node*& head) {
   //    cout<<head->data;
    struct Node* temp = head;
    //cout<<temp->data;
    head=temp->next;
    temp->next=NULL;
    head->prev=NULL;
}

void printlist(struct Node*& head) {
    struct Node* curr = head;
    
    while(curr != NULL) {
        cout << curr->data << " ";
        curr = curr->next;
    }
}

void deleteatlast(struct Node*& head) {
    struct Node* temp = head;
    
    while(temp->next != NULL) {
        temp = temp->next;
    }
    struct Node* last = temp;
    temp = last->prev;
    temp->next = NULL;
    last->prev = NULL;
    free(last);
}

void deleteatany(struct Node*& head, int pos) {
    struct Node* temp = head;
    
    for(int i = 1; i < pos-1; i++) {
        temp = temp->next;
    }
    
    struct Node* mid = temp->next;
    
    temp->next = mid->next;
    mid->next->prev = temp;
    mid->prev = NULL;
    mid->next = NULL;
    
    free(mid);
}

//question 1 size of doubly linked list
int printsize(struct Node*& head) {
    struct Node* temp = head;
    int size = 0;
    while(temp != NULL) {
        size++;
        temp = temp->next;
    }
    
    return size;
}

//question is find the pair with given sum
void find_pair_sum(Pair* arr, struct Node*& head, int sum) {
    struct Node* curr = head;
    
    int i = 0;
    while(curr->next != NULL) {
        int diff = sum - curr->data;
        struct Node* next = curr->next;
        
        while(next != NULL) {
            if(diff - next->data == 0) {
                arr[i].start = curr->data;
                arr[i].end = next->data;
                i++;
            }
            next = next->next;
        }
        
        curr = curr->next;
    }
    
    for(int j = 0; j < i; j++) {
        cout << '(' << arr[i].start << ',' << arr[i].end << ')' << '\n';
    }
}

int main()
{
    struct Node* head = NULL;
    
    insertatlast(1, head);
    insertatlast(2, head);
    insertatlast(3, head);
    insertatlast(4, head);
    
    printlist(head);
    cout<<'\n';
    
    deleteatfront(head);
    
    printlist(head);
    
    insertatany(5, head, 2);
    cout << '\n';
    printlist(head);
    
    deleteatlast(head);
    cout << '\n';
    printlist(head);
    
    deleteatany(head, 2);
    cout << '\n';
    printlist(head);
    
    //--------------------------------------
    // Question1
    int size = printsize(head);
    
    //question 2
    Pair* arr = new Pair[size];
    find_pair_sum(arr, head, 6);
}