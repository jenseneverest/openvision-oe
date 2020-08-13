DESCRIPTION = "Firmware for SDIO RTL8723BU"

LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = "git://github.com/mdamt/linux-firmware.git;protocol=git"
SRC_URI = "git://github.com/BjornLee/linux-firmware.git;protocol=git"

S = "${WORKDIR}/git"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
	install -m 0644 rtlwifi/rtl8723bu_ap_wowlan.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/
	install -m 0644 rtlwifi/rtl8723bu_nic.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/
	install -m 0644 rtlwifi/rtl8723bu_wowlan.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/
	install -m 0644 rtlwifi/rtl8723bu_bt.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/

	install -d ${D}${nonarch_base_libdir}/firmware/rtl_bt
	install -m 0644 rtl_bt/rtl8723b_fw.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt
}
