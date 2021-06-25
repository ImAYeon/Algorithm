#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

int main() {
	int n;
	int arr[1001] = { 0, };
	int result = 0;
	int left = 1000, right = 0;
	stack<int> st1, st2;

	cin >> n;
	for (int i = 0; i < n; i++) {
		int l, h;
		cin >> l >> h;
		left = min(l, left);
		right = max(l, right);
		arr[l] = h;
	}

	st1.push(left);
	for (int i = left + 1; i <= right; i++) {
		if (arr[i] > arr[st1.top()]) st1.push(i);
	}

	st2.push(right);
	for (int i = right - 1; i >= left; i--) {
		if (arr[i] > arr[st2.top()]) st2.push(i);
	}

	// 가장 높은 막대 사이 거리
	result += (st2.top() - st1.top() + 1) * arr[st1.top()];

	// 왼쪽 영역
	int prev = st1.top();
	st1.pop();
	while (!st1.empty()) {
		result += (prev - st1.top()) * arr[st1.top()];

		prev = st1.top();
		st1.pop();
	}

	// 오른쪽 영역
	prev = st2.top();
	st2.pop();
	while (!st2.empty()) {
		result += (st2.top() - prev) * arr[st2.top()];

		prev = st2.top();
		st2.pop();
	}

	cout << result;
}
