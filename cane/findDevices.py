import bluetooth

addr = None

nearby_devices = bluetooth.discover_devices()

for bdaddr in nearby_devices:
	print(bdaddr)
