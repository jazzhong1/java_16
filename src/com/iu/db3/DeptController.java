package com.iu.db3;

import java.util.*;

public class DeptController {
	private Scanner sc;
	private DeptDAO dao;
	private View view;
	private Input input;

	public DeptController() {
		sc = new Scanner(System.in);
		dao = new DeptDAO();
		view = new View();
		input = new Input();
	}

	public void start() throws Exception {

		while (true) {
			System.out.println("1.부서추가|2.전체부서조회|3.종료");
			int select = sc.nextInt();
			DeptDTO	deptDTO = new DeptDTO();

			if (select == 1) {
				deptDTO=input.inputDept();
				int result=dao.insert(deptDTO);
				
				if(result>0){
					view.view("성공");
				}
				else{
					view.view("실패 ");
				}
			}

			else if (select == 2) {
				ArrayList<DeptDTO> arrayList=dao.selectAll();
				view.view(arrayList);
			}

			else {
				break;
			}

		}
		System.out.println("종료");

	}
}
