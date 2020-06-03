RDEPENDS_bluez5 = " \
    bluez5-noinst-tools \
    bluez5-obex \
    bluez5-testtools  \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', \
        'pulseaudio-module-bluetooth-discover \
         pulseaudio-module-bluetooth-policy \
         pulseaudio-module-bluez5-discover \
         pulseaudio-module-bluez5-device \
         pulseaudio-module-switch-on-connect \
         pulseaudio-module-loopback', \
        '', d)} \
"
