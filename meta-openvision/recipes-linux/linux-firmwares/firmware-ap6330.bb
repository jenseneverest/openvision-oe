SUMMARY = "Firmware files for bcm4339a0/ap6330"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/firmware-ap6330.zip"

SRC_URI[md5sum] = "ab70395ea68e5d71a350752de083d29c"
SRC_URI[sha256sum] = "7495380d0d05536d54b50297e58a6fc461f486a96452f7c502595d1c0b9e16d8"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware/brcm"
FILES_${PN} += "${sysconfdir}/wifi/"

do_install() {
    install -d ${D}${sysconfdir}/wifi/
    install -m 0755 config.txt  ${D}${sysconfdir}/wifi/config.txt
    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    install -m 0644 ap6335e_nvram.txt ${D}${nonarch_base_libdir}/firmware/brcm/ap6335e_nvram.txt
    install -m 0644 fw_bcm4339a0_ag.bin ${D}${nonarch_base_libdir}/firmware/brcm/fw_bcm4339a0_ag.bin
}
