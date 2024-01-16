#include<iostream>
#include<stdlib.h> 
using namespace std;

struct Node /*single linked list*/
{
    int data;
    struct Node* next;
};

// struct Node /*double linked list*/
// {
//     int data;
//     struct Node* prev;
//     struct Node* next;
// };

void insertAtBeg(int data, struct Node* head) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;

    if(head == NULL) {
        head = newNode;
    } else {
        newNode->next = head;
        head = newNode;
    }
}

void insertAtlast(int data, struct Node* head) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;

    struct Node* temp = head;
    if(head == NULL) {
        head = newNode;
    } else {
            while(temp->next != NULL) {
            temp = temp->next;
        }
    }
    
    temp->next = newNode;
}

void insertAtAny(int data, struct Node* head, int pos) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;

    struct Node* temp = head;
    for(int i = 1; i < pos; i++) {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

void delinfront(struct Node* head) {
    struct Node* temp = head;
    
    head = temp->next;
    free(temp);
}

void delinlast(struct Node* head) {
    struct Node* temp = head;

    while(temp->next->next != NULL) {
        temp = temp -> next;
    }

    temp->next = NULL;
}

void delatany(struct Node* head, int pos) {
    struct Node* temp = head;

    for(int i = 1; i < pos; i++) {
        temp = temp -> next;
    }

    struct Node* curr = temp->next;
    temp->next = curr->next;
    free(curr);
}

void search(struct Node* head, int key) {
    struct Node* temp = head;

    while(temp != NULL) {
        
        if(temp->data == key) {
            cout << temp->data <<" ";
        }

        temp = temp->next;
    }
}

void sortlist(struct Node* head) {
    struct Node* curr = head;

    while(curr != NULL) {
        struct Node* index = curr->next;

        while(index != NULL) {
            
            if(curr->data > index->data) {
                int temp = curr->data;
                curr->data = index->data;
                index->data = temp;
            }

            index = index->next;
        }

        curr = curr->next;
    }
}

//question one
void sumoflinkedlist(struct Node* head) {
    struct Node* temp = head;
    int sum = 0;

    while(temp != NULL) {
        sum += temp->data;
        temp = temp->next;
    }

    cout << sum;
}

//question two
struct Node* mergelinkedlist(struct Node* head, struct Node* head1) {
    struct Node* first = head;
    struct Node* second = head1;

    while(first->next != NULL) {
        first = first -> next;
    }

    first->next = second;

    return head;
}

void insertalternate(struct Node* newll, struct Node* head) {
    struct Node* newlist = newll;
    struct Node* curr = head;

    while(curr->next != NULL || curr->next->next != NULL) {
        insertAtlast(curr->data, newlist);
        curr = curr->next->next;
    }
}

void accendingdecending(struct Node* head) {
    
}

void printList(struct Node* head) {
    struct Node* temp = head;

    while(temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
}

int main() {
    //first linked list
    struct Node* head = NULL;

    insertAtBeg(1, head);
    insertAtBeg(2, head);
    insertAtBeg(3, head);

    sortlist(head);

    printList(head);

// -----------------------------------------------

    //Q1 sum of linked list
    sumoflinkedlist(head);

    //Q2 merge two linked list and return head
    struct Node* head1 = NULL;
    
    insertAtBeg(6, head1);
    insertAtBeg(7, head1);
    insertAtBeg(8, head1);

    struct Node* newhead = (struct Node*)mergelinkedlist(head, head1);

    printList(newhead);
    
    //Q3 create new linked list with alternate position

    struct Node* newll = NULL;
    insertalternate(newll, head);

// ---------------------------------------------------

}