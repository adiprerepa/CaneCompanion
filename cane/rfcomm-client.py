import bluetooth

bd_addr = "B8:27:EB:BE:53:A7"

port = 1

sock = bluetooth.BluetoothSocket(bluetooth.RFCOMM)
sock.connect((bd_addr, port))
sock.send("yhjai")
sock.close()
