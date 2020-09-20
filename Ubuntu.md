# Ubuntu 20.04.x LTS setup
* Run our https://github.com/OpenVisionE2/openvision-oe/blob/develop/ltsubuntu.sh

# How to get latest Ubuntu 20.04.x updates
* Just run our "ltsubuntu.sh" again!

# How to use Xfce 4 desktop on Ubuntu
(as GNOME 3 wastes so many resources)

1- Disable wayland:
```
sudo gedit /etc/gdm3/custom.conf
```
(Change "#WaylandEnable=false" to "WaylandEnable=false")
```
sudo reboot
```
2- Install Xfce 4:
```
sudo apt-get install xfce4
```
