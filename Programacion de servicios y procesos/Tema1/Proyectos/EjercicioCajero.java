/*
 * EjercicioCajero.java
 * 
 * Copyright 2020 kevmar <kevmar@PC21>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 */


public class sin título {
	
	public static void main (String[] args) {
		
		VerificarCuenta vc = new VerificarCuenta();
		
		Thread Luis = new Thread(vc,"Luis");
		Thread Manuel = new Thread(vc,"Manuel");
		
		Luis.start();
		Manuel.start();
		
	}
}

public class Luis implements Runnable{

	public Luis(){
		
		}
		
		public run(){
			
			}
}
public class VerificarCuenta{
	
	private double dinero;
	
	public Cuenta(){
		
		}
	}
