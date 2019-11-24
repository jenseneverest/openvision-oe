SUMMARY = "Firmware files for bcm40181a2/ap6210"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/firmware-ap6210.zip"

SRC_URI[md5sum] = "0e797a699e29df0c3fc729335477394d"
SRC_URI[sha256sum] = "36a6b1df79344e07abe9d9619e5f844ac94573cd2f3c2a298f20006fb1f5f938"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    install -m 0644 ap6210-nvram.txt ${D}${nonarch_base_libdir}/firmware/brcm/ap6210-nvram.txt
    install -m 0644 fw_bcm40181a2.bin ${D}${nonarch_base_libdir}/firmware/brcm/fw_bcm40181a2.bin
}
