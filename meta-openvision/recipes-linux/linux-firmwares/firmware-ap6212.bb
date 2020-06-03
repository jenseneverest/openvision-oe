SUMMARY = "Firmware files for use with Linux kernel"
SECTION = "kernel"
LICENSE = "CLOSED"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/ap6212-wifi-firmware.zip"

SRC_URI[md5sum] = "c1810ebfb759d995436fcad782b0f511"
SRC_URI[sha256sum] = "bcd612bf28f3527348f333dda1f678cf024f7e793d1c0c8f01ffc0a839eb902e"

S = "${WORKDIR}/6212"

inherit allarch update-alternatives update-rc.d

INITSCRIPT_NAME = "ap6212"
INITSCRIPT_PARAMS = "defaults 10"


do_compile() {
    :
}

FILES_${PN} = " \
                ${nonarch_base_libdir} \
                ${sysconfdir} \
"

do_install() {
    install -d  ${D}${sysconfdir}/firmware/ap6212
    install -d  ${D}${nonarch_base_libdir}/firmware/ap6212
    install -m 0655 nvram.txt ${D}${nonarch_base_libdir}/firmware/ap6212
    install -m 0655 config.txt ${D}${nonarch_base_libdir}/firmware/ap6212
    install -m 0655 fw_bcm43438a0.bin ${D}${nonarch_base_libdir}/firmware/ap6212
    install -m 0655 fw_bcm43438a0_apsta.bin ${D}${nonarch_base_libdir}/firmware/ap6212
    install -m 0655 fw_bcm43438a0_p2p.bin ${D}${nonarch_base_libdir}/firmware/ap6212
    install -m 0655 bcm43438a0.hcd ${D}${nonarch_base_libdir}/firmware/ap6212/4343A0.hcd
    
    # Bluetooth
    install -m 0655 bcm43438a0.hcd ${D}${sysconfdir}/firmware/ap6212/4343A0.hcd

    # Only install the init script when 'sysvinit' is in DISTRO_FEATURES.
    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d "${D}${sysconfdir}/init.d"
        install -m 0755 ap6212-bluetooth ${D}${sysconfdir}/init.d/ap6212
        install -d "${D}${sysconfdir}/default"
        install -m 0644 ap6212-default ${D}${sysconfdir}/default/ap6212
    fi
}
